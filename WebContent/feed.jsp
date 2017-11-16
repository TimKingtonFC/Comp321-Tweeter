<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="styles/main.css" rel="stylesheet" />
<title>Tweeter</title>
</head>
<body>
	<section class="userinfo">
	Userinfo
	</section>
	<section class="feed">
		<form action="FeedServlet" method="post">
			<input type="text" name="message">
			<input type="submit" value="Tweet">
		</form>
	
		<article class="post">
		  <img class="avatar" src="${tweet.user.avatarUrl}">
		  <div class="postbody">
			  <div>
			  	<span class="name">${tweet.user.name}</span>
			  	<span class="username">${tweet.user.username}</span>
			  	<span class="time">${tweet.timestamp}</span>
		  	  </div>
			  <p class="posttext">${tweet.message}</p>
			  <div class="iconbar">
			  	<img src="comment.png">
			  	<img src="retweet.jpg">
			  	<img src="heart.png">
			  </div>
		  </div>
		</article>
	</section>
	<section class="recommendations">
	recommendations
	</section>
</body>
</html>