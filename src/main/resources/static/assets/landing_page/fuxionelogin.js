(function(){
	var canvasBody = document.getElementById("canvas"),
			canvas = canvasBody.getContext("2d"),
			
			w = canvasBody.width = window.innerWidth,
			h = canvasBody.height = window.innerHeight,
			
			tick = 0,
			pi2 = Math.PI*2,
			opts = {
				canvas: {
					backgroundColor: "#000000",
					maxBullets: 50
				},
				ball: {
					color: "rgba(155, 89, 182,1.0)",
					radius: 18,
					speed: 2,
					shootChance: 0.05,
					illumination: 25,
					connectionDistance: 350,
					offset: 200
				},
				bullet: {
					minSpeed: 2,
					addedSpeed: 0.3,
					radius: 5,
					color: "rgba(41, 128, 185,1.0)",
					illumination: 20,
					deathChance: 0.001,
					maxBounce: 2
				}
			},
			WeirdBall = function(){
				this.type = "ball";
				this.x = 0;
				this.y = 0;
				this.direction = true;
				this.speed = opts.ball.speed;
				this.radius = opts.ball.radius;
				this.color = opts.ball.color;
				this.equation = function(x){
					return [x, Math.sin(x)]
				}
				this.shoot = function(){
					if(this.x > 0 + this.radius && this.x < w - this.radius){
						var space = world.entities["bullet"] ? (world.entities["bullet"].length <= opts.canvas.maxBullets ? true : false) : true;
						var randomAngle = Math.radians(Math.random()*360);
						var newBullet = new Bullet({
							x: this.x,
							y: this.y,
							speed: {
								x: Math.cos(randomAngle)*(opts.bullet.minSpeed + Math.random()*opts.bullet.addedSpeed * (Math.random() < 0.5 ? 1 : -1)),
								y: Math.sin(randomAngle)*(opts.bullet.minSpeed + Math.random()*opts.bullet.addedSpeed * (Math.random() < 0.5 ? 1 : -1))},
							index: world.entities.length
						})
						
						if(space) world.addBody(newBullet);}
				};
				this.update = function(){
					Math.random() < opts.ball.shootChance ? this.shoot() : true;
					this.x > w + opts.ball.offset ? this.x = -opts.ball.offset : true;
					this.direction ? this.x += this.speed : this.x -= this.speed;
					this.y = this.equation(Math.radians(this.x)/2)[1]*100 + h/2;
				};
				this.render = function(){
					canvas.beginPath();
					canvas.arc(this.x, this.y, this.radius, 0, pi2);
					canvas.closePath();
					canvas.fillStyle = this.color;
					canvas.shadowColor = this.color;
					canvas.shadowBlur = opts.ball.illumination;
					canvas.fill();
					
					//Reseting the blur
					canvas.shadowBlur = 0;
				};
			},
			Bullet = function(obj){
				this.type = "bullet";
				world.entities[this.type] ? this.index = world.entities[this.type].length : true;
				this.x = obj.x;
				this.y = obj.y;
				this.speed = {};				
				this.speed.x = obj.speed.x;
				this.speed.y = obj.speed.y;
				this.gonnaDie = false;
				this.color = opts.bullet.color;
				this.radius = opts.bullet.radius;
				this.shadowBlur = opts.bullet.illumination;
				this.bounceTimes = 0;
				this.update = function(){
					//this.bounceTimes < opts.bullet.maxBounce ? this.border() : true;
					this.border();
					this.x += this.speed.x;
					this.y += this.speed.y;
				};
				this.border = function(){
					if(this.x < 0 + this.radius || this.x > w - this.radius){
						this.speed.x *= -1;
						this.bounceTimes++;
					}
					if(this.y < 0 + this.radius || this.y > h - this.radius){
						this.speed.y *= -1;
						this.bounceTimes++;
					}
				};
				this.render = function(){
					canvas.beginPath();
					canvas.arc(this.x, this.y, this.radius, 0, pi2);
					canvas.closePath();
					canvas.fillStyle = this.color;
					canvas.shadowColor = this.color;
					canvas.shadowBlur = this.shadowBlur;
					canvas.fill();
					
					//reseting the blur
					canvas.shadowBlur = 0;
				};
			},
			Mouse = {
				x: w/2,
				y: h/2
			},
			World = function(){
				this.entities = {};
				this.addBody = function(body){
					var bodyType = body.type;
					this.entities[bodyType] ? true : this.entities[bodyType] = [];
					this.entities[bodyType].push(body);
				};
				this.update = function(){
					var entityLength = Object.size(this.entities);
					for(key in this.entities){
						this.entities[key].map( function(Entity){
							Entity.update();
						})
					}
				}
				this.render = function(){
					for(key in this.entities){
						this.entities[key].map( function(Entity){
							Entity.render();
						})
					}
				}
				this.connect = function(obj){
					if(obj.style == "all-to-one"){
						if(this.entities[obj.secondary]){
							for(var i = 0; i < this.entities[obj.secondary].length; i++){
								var distance = checkDistance(this.entities[obj.secondary][i].x, this.entities[obj.secondary][i].y, this.entities[obj.main][0].x, this.entities[obj.main][0].y),
										opacity = 1 - distance/opts.ball.connectionDistance;
								if(opacity > 0){
									var gradient = canvas.createLinearGradient(
										this.entities[obj.secondary][i].x, this.entities[obj.secondary][i].y, this.entities[obj.main][0].x, this.entities[obj.main][0].y
									);
									gradient.addColorStop(0, this.entities[obj.secondary][i].color.replace("1.0", opacity));
									gradient.addColorStop(1, this.entities[obj.main][0].color.replace("1.0", opacity));
									canvas.lineWidth = 0.5;
									canvas.strokeStyle = gradient
									canvas.beginPath();
									canvas.moveTo(this.entities[obj.secondary][i].x, this.entities[obj.secondary][i].y);
									canvas.lineTo(this.entities[obj.main][0].x, this.entities[obj.main][0].y);
									canvas.shadowBlur = 4;
									canvas.shadowColor = this.entities[obj.secondary][i].color.replace("1.0", opacity)
									canvas.closePath();
									canvas.stroke();
								}
							}
						}
					}
				}
			},
			checkDistance = function(x1, y1, x2, y2){
				return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			}
			Object.size = function(obj) {
				var size = 0, key;
				for (key in obj) {
					if (obj.hasOwnProperty(key)) size++;
				}
				return size;
			};
	Math.radians = function(deg){
		return deg * (Math.PI / 180)
	}
	function setup(){
		world = new World();
		world.addBody( new WeirdBall() );
		window.requestAnimationFrame(loop);
	};
	function loop(){
		canvas.fillStyle = opts.canvas.backgroundColor;
		canvas.fillRect(0,0,w,h);
		
		world.update();
		world.render();
		world.connect({
			style: "all-to-one",
			main: "ball",
			secondary: "bullet"
		});
		window.requestAnimationFrame(loop);
	};
	setup();
	
	window.addEventListener("resize", function(){
		w = canvasBody.width = window.innerWidth;
		h = canvasBody.height = window.innerHeight;
	});
	window.addEventListener("mousemove", function(e){
		Mouse.x = e.pageX;
		Mouse.y = e.pageY;
	});
})();


$(document).ready(function() {
	$('#fppanel').hide();
	$('#lpclick').hide();

	$("#fpclick").click(function(){
	    $("#lpclick").toggle();
	    $("#fppanel").toggle();
	    $("#loginpanel").toggle();
	    $(this).toggle();
	});
	$("#lpclick").click(function(){
	    $("#fpclick").toggle();
	    $("#fppanel").toggle();
	    $("#loginpanel").toggle();
	    $(this).toggle();
	});

});
