//  Created by react-native-create-bridge

package com.reactnativesift.siftmodule;

import android.support.annotation.Nullable;
import android.widget.Toast;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;

import siftscience.android.Sift;


public class SiftModuleModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "SiftModule";
    private static ReactApplicationContext reactContext = null;

    public SiftModuleModule(ReactApplicationContext context) {
        // Pass in the context to the constructor and save it so you can emit events
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        super(context);

        reactContext = context;
    }

    @Override
    public String getName() {
        // Tell React the name of the module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        return REACT_CLASS;
    }

    @Override
    public Map<String, Object> getConstants() {
        // Export any constants to be used in your native module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        final Map<String, Object> constants = new HashMap<>();
        constants.put("EXAMPLE_CONSTANT", "exampleAndroid");

        return constants;
    }

    @ReactMethod
    public void exampleMethod () {
        // An example native method that you will expose to React
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
    }

    @ReactMethod
    public void initSdk (String accountid,String beaconkey) {
        Sift.open(reactContext, new Sift.Config.Builder()
                .withAccountId(accountid)
                .withBeaconKey(beaconkey)
                .build());
        Sift.collect();
    }


    @ReactMethod
    public void setUserId (String userId) {
        Sift.setUserId(userId);
    }


    @ReactMethod
    public void haseebTest (Promise promise) {
        // An example native method that you will expose to React
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        Toast.makeText(getReactApplicationContext(),"My name is haseeb Android",Toast.LENGTH_LONG).show();
       String str="My name is haseeb Android";
//        return str;
        promise.resolve(str);
    }

    private static void emitDeviceEvent(String eventName, @Nullable WritableMap eventData) {
        // A method for emitting from the native side to JS
        // https://facebook.github.io/react-native/docs/native-modules-android.html#sending-events-to-javascript
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, eventData);
    }
}
