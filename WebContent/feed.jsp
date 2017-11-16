<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://tweetertags.com"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="styles/main.css" rel="stylesheet" />
<title>Tweeter</title>
</head>
<body>
	<section class="userinfo">
	Logged in as: ${user.name}
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
	</section>
	<section class="feed">
		<form action="feed" method="post">
			<input type="text" name="message">
			<input type="submit" value="Tweet">
		</form>

		<t:tweets>
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
				  	<a href="retweet?id=${tweet.id }"><img src="retweet.jpg"></a>${tweet.numRetweets}
				  	<a href="like?id=${tweet.id }"><img src="heart.png"></a>${tweet.numLikes}
				  </div>
			  </div>
			</article>
		</t:tweets>
	</section>
	<section class="recommendations">
	recommendations
	</section>
</body>
</html>