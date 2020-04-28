insert into features (name) values ('A') ON CONFLICT DO NOTHING;
insert into features (name) values ('B') ON CONFLICT DO NOTHING;
insert into features (name) values ('C') ON CONFLICT DO NOTHING;

-- Feature A SW Required codes
insert into codes (code, is_hardware) values ('GdS6TI', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('93ZSw9', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('btZUSp', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('MZgsou', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('Di75Ry', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('0vhcNa', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('33MHDf', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('L34Pur', false) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('A', 'GdS6TI', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', '93ZSw9', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'btZUSp', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'MZgsou', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'Di75Ry', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', '0vhcNa', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', '33MHDf', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'L34Pur', true) ON CONFLICT DO NOTHING;

-- Feature A SW Incompatible codes
insert into codes (code, is_hardware) values ('ykzkfK', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('87Zhwo', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('y4XKWo', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('ay0pW2', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('44OmDi', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('aJsd3i', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('Qoflqf', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('2EzZXE', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('j3mmf8', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('MUR8Lx', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('E6GYk7', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('rDJyQX', false) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('A', 'ykzkfK', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', '87Zhwo', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'y4XKWo', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'ay0pW2', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', '44OmDi', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'aJsd3i', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'Qoflqf', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', '2EzZXE', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'j3mmf8', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'MUR8Lx', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'E6GYk7', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'rDJyQX', false) ON CONFLICT DO NOTHING;

-- Feature A HW Required codes
insert into codes (code, is_hardware) values ('rlTcbX', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('wEEA00', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('SoF5uL', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('VhB9VY', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('NWytcy', true) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('A', 'rlTcbX', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'wEEA00', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'SoF5uL', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'VhB9VY', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'NWytcy', true) ON CONFLICT DO NOTHING;

-- Feature A HW Incompatible codes
insert into codes (code, is_hardware) values ('yZDXJJ', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('tMI8bI', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('DS8tZU', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('PgOtkv', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('PuyTwj', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('ObZw28', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('ZCLFOe', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('jyP5PK', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('pS5ZQs', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('rcjjPX', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('6VO6Uq', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('DAlCk4', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('YxKjcX', true) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('A', 'yZDXJJ', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'tMI8bI', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'DS8tZU', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'PgOtkv', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'PuyTwj', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'ObZw28', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'ZCLFOe', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'jyP5PK', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'pS5ZQs', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'rcjjPX', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', '6VO6Uq', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'DAlCk4', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('A', 'YxKjcX', false) ON CONFLICT DO NOTHING;

-- Feature B SW Required codes
insert into codes (code, is_hardware) values ('FhFXVE', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('FVlp0N', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('I25pUg', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('PeQWGL', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('LYZzKL', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('Cd9t6T', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('pYgxjp', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('T55Adn', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('cjKv9N', false) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('B', 'FhFXVE', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'FVlp0N', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'I25pUg', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'PeQWGL', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'LYZzKL', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'Cd9t6T', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'pYgxjp', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'T55Adn', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'cjKv9N', true) ON CONFLICT DO NOTHING;

-- Feature B SW Incompatible codes
-- (1 was already present in codes table)
insert into codes (code, is_hardware) values ('yfepdF', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('Q54BVi', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('1QNx4P', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('u9XCsm', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('RgrAEU', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('0M97HZ', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('BD80qR', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('RGOkrt', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('LV7Msr', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('0OEvxe', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('VLyf6R', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('s1I5dm', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('I4wRf9', false) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('B', 'yfepdF', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'Q54BVi', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', '1QNx4P', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'u9XCsm', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'RgrAEU', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', '0M97HZ', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'BD80qR', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'RGOkrt', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'y4XKWo', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'LV7Msr', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', '0OEvxe', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'VLyf6R', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 's1I5dm', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'I4wRf9', false) ON CONFLICT DO NOTHING;

-- Feature B HW Required codes
insert into codes (code, is_hardware) values ('fMm4Hl', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('PWO7oa', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('F73iHn', true) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('B', 'fMm4Hl', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'PWO7oa', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'F73iHn', true) ON CONFLICT DO NOTHING;

-- Feature B HW incompatible codes
insert into codes (code, is_hardware) values ('mrGqkV', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('Ps19N7', true) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('B', 'mrGqkV', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('B', 'Ps19N7', false) ON CONFLICT DO NOTHING;

-- Feature C SW Required codes
-- (2 were already present in codes table)
insert into codes (code, is_hardware) values ('CtbvOZ', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('bpdM7a', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('rTM6gD', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('LvXPPT', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('Gwz57A', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('NNTgVk', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('dt5WJj', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('zTUQwE', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('ufX8mD', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('UPCZFv', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('uUZjNJ', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('ljnm95', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('QP8Bls', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('egNmFq', false) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('PJyE8c', false) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('C', 'CtbvOZ', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'bpdM7a', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'rTM6gD', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'LvXPPT', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'Gwz57A', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'NNTgVk', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'dt5WJj', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'zTUQwE', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'ufX8mD', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', '0vhcNa', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'UPCZFv', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'uUZjNJ', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'ljnm95', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'QP8Bls', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'egNmFq', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'PJyE8c', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'pYgxjp', true) ON CONFLICT DO NOTHING;

-- Feature C SW incompatible codes
insert into codes (code, is_hardware) values ('T2WuvF', false) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('C', 'T2WuvF', false) ON CONFLICT DO NOTHING;

-- Feature C HW required codes
insert into codes (code, is_hardware) values ('wv2CZs', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('CEuBzO', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('Cu5fGc', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('jvqI5i', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('pZLSFn', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('eUMxfa', true) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('C', 'wv2CZs', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'CEuBzO', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'Cu5fGc', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'jvqI5i', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'pZLSFn', true) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'eUMxfa', true) ON CONFLICT DO NOTHING;

-- Feature C HW incompatible codes
insert into codes (code, is_hardware) values ('JY3Vcn', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('8PielJ', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('NcOLyY', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('Zfahrb', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('iKALCh', true) ON CONFLICT DO NOTHING;
insert into codes (code, is_hardware) values ('6IHTbr', true) ON CONFLICT DO NOTHING;

insert into feature_codes (feature_name, code, is_required) values ('C', 'JY3Vcn', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', '8PielJ', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'NcOLyY', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'Zfahrb', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', 'iKALCh', false) ON CONFLICT DO NOTHING;
insert into feature_codes (feature_name, code, is_required) values ('C', '6IHTbr', false) ON CONFLICT DO NOTHING;