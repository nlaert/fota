insert into features (name) values ('A');
insert into features (name) values ('B');
insert into features (name) values ('C');

-- Feature A SW Required codes
insert into codes (code, is_hardware) values ('GdS6TI', false);
insert into codes (code, is_hardware) values ('93ZSw9', false);
insert into codes (code, is_hardware) values ('btZUSp', false);
insert into codes (code, is_hardware) values ('MZgsou', false);
insert into codes (code, is_hardware) values ('Di75Ry', false);
insert into codes (code, is_hardware) values ('0vhcNa', false);
insert into codes (code, is_hardware) values ('33MHDf', false);
insert into codes (code, is_hardware) values ('L34Pur', false);

insert into feature_codes (feature_name, code, is_required) values ('A', 'GdS6TI', true);
insert into feature_codes (feature_name, code, is_required) values ('A', '93ZSw9', true);
insert into feature_codes (feature_name, code, is_required) values ('A', 'btZUSp', true);
insert into feature_codes (feature_name, code, is_required) values ('A', 'MZgsou', true);
insert into feature_codes (feature_name, code, is_required) values ('A', 'Di75Ry', true);
insert into feature_codes (feature_name, code, is_required) values ('A', '0vhcNa', true);
insert into feature_codes (feature_name, code, is_required) values ('A', '33MHDf', true);
insert into feature_codes (feature_name, code, is_required) values ('A', 'L34Pur', true);

-- Feature A SW Incompatible codes
insert into codes (code, is_hardware) values ('ykzkfK', false);
insert into codes (code, is_hardware) values ('87Zhwo', false);
insert into codes (code, is_hardware) values ('y4XKWo', false);
insert into codes (code, is_hardware) values ('ay0pW2', false);
insert into codes (code, is_hardware) values ('44OmDi', false);
insert into codes (code, is_hardware) values ('aJsd3i', false);
insert into codes (code, is_hardware) values ('Qoflqf', false);
insert into codes (code, is_hardware) values ('2EzZXE', false);
insert into codes (code, is_hardware) values ('j3mmf8', false);
insert into codes (code, is_hardware) values ('MUR8Lx', false);
insert into codes (code, is_hardware) values ('E6GYk7', false);
insert into codes (code, is_hardware) values ('rDJyQX', false);

insert into feature_codes (feature_name, code, is_required) values ('A', 'ykzkfK', false);
insert into feature_codes (feature_name, code, is_required) values ('A', '87Zhwo', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'y4XKWo', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'ay0pW2', false);
insert into feature_codes (feature_name, code, is_required) values ('A', '44OmDi', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'aJsd3i', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'Qoflqf', false);
insert into feature_codes (feature_name, code, is_required) values ('A', '2EzZXE', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'j3mmf8', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'MUR8Lx', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'E6GYk7', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'rDJyQX', false);

-- Feature A HW Required codes
insert into codes (code, is_hardware) values ('rlTcbX', true);
insert into codes (code, is_hardware) values ('wEEA00', true);
insert into codes (code, is_hardware) values ('SoF5uL', true);
insert into codes (code, is_hardware) values ('VhB9VY', true);
insert into codes (code, is_hardware) values ('NWytcy', true);

insert into feature_codes (feature_name, code, is_required) values ('A', 'rlTcbX', true);
insert into feature_codes (feature_name, code, is_required) values ('A', 'wEEA00', true);
insert into feature_codes (feature_name, code, is_required) values ('A', 'SoF5uL', true);
insert into feature_codes (feature_name, code, is_required) values ('A', 'VhB9VY', true);
insert into feature_codes (feature_name, code, is_required) values ('A', 'NWytcy', true);

-- Feature A HW Incompatible codes
insert into codes (code, is_hardware) values ('yZDXJJ', true);
insert into codes (code, is_hardware) values ('tMI8bI', true);
insert into codes (code, is_hardware) values ('DS8tZU', true);
insert into codes (code, is_hardware) values ('PgOtkv', true);
insert into codes (code, is_hardware) values ('PuyTwj', true);
insert into codes (code, is_hardware) values ('ObZw28', true);
insert into codes (code, is_hardware) values ('ZCLFOe', true);
insert into codes (code, is_hardware) values ('jyP5PK', true);
insert into codes (code, is_hardware) values ('pS5ZQs', true);
insert into codes (code, is_hardware) values ('rcjjPX', true);
insert into codes (code, is_hardware) values ('6VO6Uq', true);
insert into codes (code, is_hardware) values ('DAlCk4', true);
insert into codes (code, is_hardware) values ('YxKjcX', true);

insert into feature_codes (feature_name, code, is_required) values ('A', 'yZDXJJ', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'tMI8bI', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'DS8tZU', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'PgOtkv', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'PuyTwj', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'ObZw28', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'ZCLFOe', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'jyP5PK', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'pS5ZQs', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'rcjjPX', false);
insert into feature_codes (feature_name, code, is_required) values ('A', '6VO6Uq', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'DAlCk4', false);
insert into feature_codes (feature_name, code, is_required) values ('A', 'YxKjcX', false);

-- Feature B SW Required codes
insert into codes (code, is_hardware) values ('FhFXVE', false);
insert into codes (code, is_hardware) values ('FVlp0N', false);
insert into codes (code, is_hardware) values ('I25pUg', false);
insert into codes (code, is_hardware) values ('PeQWGL', false);
insert into codes (code, is_hardware) values ('LYZzKL', false);
insert into codes (code, is_hardware) values ('Cd9t6T', false);
insert into codes (code, is_hardware) values ('pYgxjp', false);
insert into codes (code, is_hardware) values ('T55Adn', false);
insert into codes (code, is_hardware) values ('cjKv9N', false);

insert into feature_codes (feature_name, code, is_required) values ('B', 'FhFXVE', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'FVlp0N', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'I25pUg', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'PeQWGL', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'LYZzKL', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'Cd9t6T', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'pYgxjp', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'T55Adn', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'cjKv9N', true);

-- Feature B SW Incompatible codes
-- (1 was already present in codes table)
insert into codes (code, is_hardware) values ('yfepdF', false);
insert into codes (code, is_hardware) values ('Q54BVi', false);
insert into codes (code, is_hardware) values ('1QNx4P', false);
insert into codes (code, is_hardware) values ('u9XCsm', false);
insert into codes (code, is_hardware) values ('RgrAEU', false);
insert into codes (code, is_hardware) values ('0M97HZ', false);
insert into codes (code, is_hardware) values ('BD80qR', false);
insert into codes (code, is_hardware) values ('RGOkrt', false);
insert into codes (code, is_hardware) values ('LV7Msr', false);
insert into codes (code, is_hardware) values ('0OEvxe', false);
insert into codes (code, is_hardware) values ('VLyf6R', false);
insert into codes (code, is_hardware) values ('s1I5dm', false);
insert into codes (code, is_hardware) values ('I4wRf9', false);

insert into feature_codes (feature_name, code, is_required) values ('B', 'yfepdF', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'Q54BVi', false);
insert into feature_codes (feature_name, code, is_required) values ('B', '1QNx4P', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'u9XCsm', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'RgrAEU', false);
insert into feature_codes (feature_name, code, is_required) values ('B', '0M97HZ', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'BD80qR', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'RGOkrt', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'y4XKWo', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'LV7Msr', false);
insert into feature_codes (feature_name, code, is_required) values ('B', '0OEvxe', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'VLyf6R', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 's1I5dm', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'I4wRf9', false);

-- Feature B HW Required codes
insert into codes (code, is_hardware) values ('fMm4Hl', true);
insert into codes (code, is_hardware) values ('PWO7oa', true);
insert into codes (code, is_hardware) values ('F73iHn', true);

insert into feature_codes (feature_name, code, is_required) values ('B', 'fMm4Hl', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'PWO7oa', true);
insert into feature_codes (feature_name, code, is_required) values ('B', 'F73iHn', true);

-- Feature B HW incompatible codes
insert into codes (code, is_hardware) values ('mrGqkV', true);
insert into codes (code, is_hardware) values ('Ps19N7', true);

insert into feature_codes (feature_name, code, is_required) values ('B', 'mrGqkV', false);
insert into feature_codes (feature_name, code, is_required) values ('B', 'Ps19N7', false);

-- Feature C SW Required codes
-- (2 were already present in codes table)
insert into codes (code, is_hardware) values ('CtbvOZ', false);
insert into codes (code, is_hardware) values ('bpdM7a', false);
insert into codes (code, is_hardware) values ('rTM6gD', false);
insert into codes (code, is_hardware) values ('LvXPPT', false);
insert into codes (code, is_hardware) values ('Gwz57A', false);
insert into codes (code, is_hardware) values ('NNTgVk', false);
insert into codes (code, is_hardware) values ('dt5WJj', false);
insert into codes (code, is_hardware) values ('zTUQwE', false);
insert into codes (code, is_hardware) values ('ufX8mD', false);
insert into codes (code, is_hardware) values ('UPCZFv', false);
insert into codes (code, is_hardware) values ('uUZjNJ', false);
insert into codes (code, is_hardware) values ('ljnm95', false);
insert into codes (code, is_hardware) values ('QP8Bls', false);
insert into codes (code, is_hardware) values ('egNmFq', false);
insert into codes (code, is_hardware) values ('PJyE8c', false);

insert into feature_codes (feature_name, code, is_required) values ('C', 'CtbvOZ', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'bpdM7a', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'rTM6gD', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'LvXPPT', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'Gwz57A', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'NNTgVk', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'dt5WJj', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'zTUQwE', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'ufX8mD', true);
insert into feature_codes (feature_name, code, is_required) values ('C', '0vhcNa', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'UPCZFv', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'uUZjNJ', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'ljnm95', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'QP8Bls', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'egNmFq', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'PJyE8c', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'pYgxjp', true);

-- Feature C SW incompatible codes
insert into codes (code, is_hardware) values ('T2WuvF', false);

insert into feature_codes (feature_name, code, is_required) values ('C', 'T2WuvF', false);

-- Feature C HW required codes
insert into codes (code, is_hardware) values ('wv2CZs', true);
insert into codes (code, is_hardware) values ('CEuBzO', true);
insert into codes (code, is_hardware) values ('Cu5fGc', true);
insert into codes (code, is_hardware) values ('jvqI5i', true);
insert into codes (code, is_hardware) values ('pZLSFn', true);
insert into codes (code, is_hardware) values ('eUMxfa', true);

insert into feature_codes (feature_name, code, is_required) values ('C', 'wv2CZs', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'CEuBzO', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'Cu5fGc', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'jvqI5i', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'pZLSFn', true);
insert into feature_codes (feature_name, code, is_required) values ('C', 'eUMxfa', true);

-- Feature C HW incompatible codes
insert into codes (code, is_hardware) values ('JY3Vcn', true);
insert into codes (code, is_hardware) values ('8PielJ', true);
insert into codes (code, is_hardware) values ('NcOLyY', true);
insert into codes (code, is_hardware) values ('Zfahrb', true);
insert into codes (code, is_hardware) values ('iKALCh', true);
insert into codes (code, is_hardware) values ('6IHTbr', true);

insert into feature_codes (feature_name, code, is_required) values ('C', 'JY3Vcn', false);
insert into feature_codes (feature_name, code, is_required) values ('C', '8PielJ', false);
insert into feature_codes (feature_name, code, is_required) values ('C', 'NcOLyY', false);
insert into feature_codes (feature_name, code, is_required) values ('C', 'Zfahrb', false);
insert into feature_codes (feature_name, code, is_required) values ('C', 'iKALCh', false);
insert into feature_codes (feature_name, code, is_required) values ('C', '6IHTbr', false);