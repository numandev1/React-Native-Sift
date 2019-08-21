//  Created by react-native-create-bridge

import { NativeModules } from 'react-native';

const { SiftModule } = NativeModules;

export default {
	exampleMethod(id) {
		return SiftModule.exampleMethod(id);
	},
	haseebTest() {
		return SiftModule.haseebTest();
	},
	initSdk(accountid, beaconkey) {
		return SiftModule.initSdk(accountid, beaconkey);
	},
	setUserId(id) {
		return SiftModule.setUserId(id);
	},

	EXAMPLE_CONSTANT: SiftModule.EXAMPLE_CONSTANT
};
