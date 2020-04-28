insert into features (name) values ('X');
insert into features (name) values ('Y');
insert into features (name) values ('Z');

-- Feature X SW Required codes
insert into codes (code, is_hardware) values ('codeSWRX', FALSE);
insert into codes (code, is_hardware) values ('codeSWRX2', FALSE);

insert into feature_codes (feature_name, code, is_required) values ('X', 'codeSWRX', TRUE);
insert into feature_codes (feature_name, code, is_required) values ('X', 'codeSWRX2', TRUE);

-- Feature X SW Incompatible codes
insert into codes (code, is_hardware) values ('codeSWX', FALSE);
insert into codes (code, is_hardware) values ('codeSWX2', FALSE);

insert into feature_codes (feature_name, code, is_required) values ('X', 'codeSWX', FALSE);
insert into feature_codes (feature_name, code, is_required) values ('X', 'codeSWX2', FALSE);

-- Feature X HW Required codes
insert into codes (code, is_hardware) values ('codeHWRX', TRUE);

insert into feature_codes (feature_name, code, is_required) values ('X', 'codeHWRX', TRUE);

-- Feature X HW Incompatible codes
insert into codes (code, is_hardware) values ('codeHWX', TRUE);

insert into feature_codes (feature_name, code, is_required) values ('X', 'codeHWX', FALSE);

-- Feature Y SW Required codes
insert into codes (code, is_hardware) values ('codeSWRY', FALSE);

insert into feature_codes (feature_name, code, is_required) values ('Y', 'codeSWRY', TRUE);

-- Feature Y SW Incompatible codes
insert into codes (code, is_hardware) values ('codeSWY', FALSE);

insert into feature_codes (feature_name, code, is_required) values ('Y', 'codeSWY', FALSE);

-- Feature Z SW Required codes
insert into codes (code, is_hardware) values ('codeSWRZ', FALSE);
insert into codes (code, is_hardware) values ('codeSWRZ2', FALSE);

insert into feature_codes (feature_name, code, is_required) values ('Z', 'codeSWRZ', TRUE);
insert into feature_codes (feature_name, code, is_required) values ('Z', 'codeSWRZ2', TRUE);

-- Feature Z SW incompatible codes
insert into codes (code, is_hardware) values ('codeSWZ', FALSE);

insert into feature_codes (feature_name, code, is_required) values ('Z', 'codeSWZ', FALSE);

-- Feature Z HW required codes
insert into codes (code, is_hardware) values ('codeHWRZ', TRUE);
insert into codes (code, is_hardware) values ('codeHWRZ2', TRUE);

insert into feature_codes (feature_name, code, is_required) values ('Z', 'codeHWRZ', TRUE);
insert into feature_codes (feature_name, code, is_required) values ('Z', 'codeHWRZ2', TRUE);

-- Feature Z HW incompatible codes
insert into codes (code, is_hardware) values ('codeHWZ', TRUE);
insert into codes (code, is_hardware) values ('codeHWZ2', TRUE);

insert into feature_codes (feature_name, code, is_required) values ('Z', 'codeHWZ', FALSE);
insert into feature_codes (feature_name, code, is_required) values ('Z', 'codeHWZ2', FALSE);

-- Vehicles
insert into vehicles (vin) values ('compatibleFeatureX');
insert into vehicles (vin) values ('incompatibleFeatureX');
insert into vehicles (vin) values ('compatibleFeatureYAndZ');
insert into vehicles (vin) values ('compatibleFeatureYIncompatibleZ');

insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureX', 'codeSWRX');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureX', 'codeSWRX2');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureX', 'codeHWRX');

insert into vehicle_codes (version, vehicle, code) values (0, 'incompatibleFeatureX', 'codeSWRX');
insert into vehicle_codes (version, vehicle, code) values (0, 'incompatibleFeatureX', 'codeSWRX2');
insert into vehicle_codes (version, vehicle, code) values (0, 'incompatibleFeatureX', 'codeSWX');

insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYAndZ', 'codeSWRY');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYAndZ', 'codeSWRZ2');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYAndZ', 'codeSWRZ');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYAndZ', 'codeHWRZ');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYAndZ', 'codeHWRZ2');

insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYIncompatibleZ', 'codeSWRY');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYIncompatibleZ', 'codeSWRZ');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYIncompatibleZ', 'codeSWRZ2');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYIncompatibleZ', 'codeHWRZ2');
insert into vehicle_codes (version, vehicle, code) values (0, 'compatibleFeatureYIncompatibleZ', 'codeHWZ');
