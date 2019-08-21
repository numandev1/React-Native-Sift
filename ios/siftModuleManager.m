//  Created by react-native-create-bridge

#import "SiftModule.h"

// import RCTBridge
#if __has_include(<React/RCTBridge.h>)
#import <React/RCTBridge.h>
#elif __has_include(“RCTBridge.h”)
#import “RCTBridge.h”
#else
#import “React/RCTBridge.h” // Required when used as a Pod in a Swift project
#endif

// import RCTEventDispatcher
#if __has_include(<React/RCTEventDispatcher.h>)
#import <React/RCTEventDispatcher.h>
#elif __has_include(“RCTEventDispatcher.h”)
#import “RCTEventDispatcher.h”
#else
#import “React/RCTEventDispatcher.h” // Required when used as a Pod in a Swift project
#endif

#import "Sift/Sift.h"

@implementation SiftModule
@synthesize bridge = _bridge;

// Export a native module
// https://facebook.github.io/react-native/docs/native-modules-ios.html
RCT_EXPORT_MODULE();

// Export constants
// https://facebook.github.io/react-native/releases/next/docs/native-modules-ios.html#exporting-constants
- (NSDictionary *)constantsToExport
{
  return @{
           @"EXAMPLE_CONSTANT": @"exampleIOS"
         };
}




// Return the native view that represents your React component
- (UIView *)view
{
  return [[UIView alloc] init];
}

// Export methods to a native module
// https://facebook.github.io/react-native/docs/native-modules-ios.html
RCT_EXPORT_METHOD(exampleMethod)
{
  [self emitMessageToRN:@"EXAMPLE_EVENT" :nil];
}

RCT_EXPORT_METHOD(initSdk:(NSString *) accountid beaconkey:(NSString *)beaconkey)
{
  Sift *sift = [Sift sharedInstance];
  [sift setAccountId:accountid];
  [sift setBeaconKey:beaconkey];
  [sift setAllowUsingMotionSensors:NO];
  [sift setDisallowCollectingLocationData:YES];
}

RCT_EXPORT_METHOD(setUserId:(NSString *) userId)
{
  [[Sift sharedInstance] setUserId:userId];
}



RCT_EXPORT_METHOD(
                  haseebTest:(RCTPromiseResolveBlock) promise
                  rejecter:(RCTPromiseRejectBlock) reject)
{
//  return "My name is haseeb Android";
  promise(@"messageData");
}

#pragma mark - Private methods

// Implement methods that you want to export to the native module
- (void) emitMessageToRN: (NSString *)eventName :(NSDictionary *)params {
  // The bridge eventDispatcher is used to send events from native to JS env
  // No documentation yet on DeviceEventEmitter: https://github.com/facebook/react-native/issues/2819
  [self.bridge.eventDispatcher sendAppEventWithName: eventName body: params];
}

@end
