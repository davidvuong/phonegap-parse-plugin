## Cordova Parse Push Plugin

Cordova plugin for Parse.com PUSH service.

This plugin exposes the four native Android API push services to JS:
* <a href="https://www.parse.com/docs/android/api/com/parse/ParseInstallation.html#getInstallationId()">getInstallationId</a>
* <a href="https://www.parse.com/docs/android/api/com/parse/PushService.html#getSubscriptions(android.content.Context)">getSubscriptions</a>
* <a href="https://www.parse.com/docs/android/api/com/parse/ParsePush.html#subscribeInBackground(java.lang.String)">subscribe</a> - Modified for `subscribeInBackground`
* <a href="https://www.parse.com/docs/android/api/com/parse/ParsePush.html#unsubscribeInBackground(java.lang.String)">unsubscribe</a> - Modified for `unsubscribeInBackground`

### Installation

```
cordova plugin add https://github.com/davidvuong/phonegap-parse-plugin.git
```

*Tested on iOS & forked repository had it tested on Android.*

Initial Setup
-------------

After the plugin has been installed a few things happen:

In your Application Class -> ```onCreate()``` call ```ParsePlugin.initializeParseWithApplication(this);```. This will register the device with Parse, you should see this reflected in your Parse control panel.

```js
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

### Usage

```js
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

