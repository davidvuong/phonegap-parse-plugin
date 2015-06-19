Cordova Parse.com Plugin
=========================

Cordova plugin for Parse.com PUSH service

This plugin exposes the four native Android API push services to JS:
* <a href="https://www.parse.com/docs/android/api/com/parse/ParseInstallation.html#getInstallationId()">getInstallationId</a>
* <a href="https://www.parse.com/docs/android/api/com/parse/PushService.html#getSubscriptions(android.content.Context)">getSubscriptions</a>
* <a href="https://www.parse.com/docs/android/api/com/parse/ParsePush.html#subscribeInBackground(java.lang.String)">subscribe</a> - Modified for ```subscribeInBackground```
* <a href="https://www.parse.com/docs/android/api/com/parse/ParsePush.html#unsubscribeInBackground(java.lang.String)">unsubscribe</a> - Modified for ```unsubscribeInBackground```

Installation
------------

```
cordova plugin add https://github.com/jumpbytehq/phonegap-parse-plugin --variable APP_ID=YOUR_APP_ID --variable CLIENT_KEY=YOUR_CLIENT_KEY
```

Initial Setup
-------------

In your Application Class -> ```onCreate()``` call ```ParsePlugin.initializeParseWithApplication(this);```. This will register the device with Parse, you should see this reflected in your Parse control panel.

```
parsePlugin.initialize(appId, clientKey, function() {

	parsePlugin.subscribe('SampleChannel', function() {
		
		parsePlugin.getInstallationId(function(id) {
		
			/**
			 * Now you can construct an object and save it to your own services, or Parse, and corrilate users to parse installations
			 * 
			 var install_data = {
			  	installation_id: id,
			  	channels: ['SampleChannel']
			 }
			 *
			 */

		}, function(e) {
			alert('error');
		});

	}, function(e) {
		alert('error');
	});
	
}, function(e) {
	alert('error');
});

```


Usage
-----
```
	parsePlugin.initialize(appId, clientKey, function() {
		alert('success');
	}, function(e) {
		alert('error');
	});
  
	// Tested & Working
	parsePlugin.getInstallationId(function(id) {
		alert(id);
	}, function(e) {
		alert('error');
	});
	
	parsePlugin.getSubscriptions(function(subscriptions) {
		alert(subscriptions);
	}, function(e) {
		alert('error');
	});
	
	// Tested & Working
	parsePlugin.subscribe('SampleChannel', function() {
		alert('OK');
	}, function(e) {
		alert('error');
	});
	
	// Tested & Working
	parsePlugin.unsubscribe('SampleChannel', function(msg) {
		alert('OK');
	}, function(e) {
		alert('error');
	});

```

Compatibility
-------------
Tested with Cordova >= 5.0.0
