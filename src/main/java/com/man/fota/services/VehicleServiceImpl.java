package com.man.fota.services;

import com.man.fota.entities.CodeEntity;
import com.man.fota.entities.FeatureEntity;
import com.man.fota.entities.VehicleCodesEntity;
import com.man.fota.entities.VehicleEntity;
import com.man.fota.repositories.CodeRepository;
import com.man.fota.repositories.FeatureRepository;
import com.man.fota.repositories.VehicleCodesRepository;
import com.man.fota.repositories.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleServiceImpl.class);

    private final VehicleRepository vehicleRepository;
    private final CodeRepository codeRepository;
    private final VehicleCodesRepository vehicleCodesRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public VehicleServiceImpl(final FeatureRepository featureRepository,
                              final VehicleRepository vehicleRepository,
                              final CodeRepository codeRepository,
                              final VehicleCodesRepository vehicleCodesRepository) {
        this.featureRepository = featureRepository;
        this.vehicleRepository = vehicleRepository;
        this.codeRepository = codeRepository;
        this.vehicleCodesRepository = vehicleCodesRepository;
    }

    @Override
    public List<FeatureEntity> getInstallableFeaturesByVehicle(String vin) {
        return featureRepository.getFeaturesByVin(vin, true);
    }

    @Override
    public List<FeatureEntity> getIncompatibleFeaturesByVehicle(String vin) {
        return featureRepository.getFeaturesByVin(vin, false);
    }

    @Override
    public List<FeatureEntity> getAllFeaturesByVehicle(String vin) {
        return featureRepository.getFeaturesByVin(vin, null);
    }

    @Override
    public List<VehicleEntity> getAll() {
        return vehicleRepository.findAll();
    }

    @Transactional
    @Override
    public void saveBatch(final String fileName,
                          final Set<VehicleEntity> vehicles,
                          final Set<CodeEntity> codes,
                          final List<VehicleCodesEntity> vehicleCodes) {
        LOG.debug("Inserting {} lines of file {}", vehicleCodes.size(), fileName);
        vehicleRepository.saveAll(vehicles);
        codeRepository.saveAll(codes);
        vehicleCodesRepository.insertAllIfNotExists(vehicleCodes);
        LOG.debug("Finished inserting lines of file {}", vehicleCodes.size());
    }

    /**
     * Queries the DB to check for duplicate and remove them from the lists. NOTE: This will change the given lists
     * @param vehicles
     * @param codes
     * @param vehicleCodes
     */
    private void removeDuplicates(final Set<VehicleEntity> vehicles,
                                  final Set<CodeEntity> codes,
                                  final List<VehicleCodesEntity> vehicleCodes) {

        vehicles.removeAll(vehicleRepository.findAllById(vehicles.stream()
                .map(VehicleEntity::getVin).collect(Collectors.toList())));
        codes.removeAll(codeRepository.findAllById(codes.stream()
                .map(CodeEntity::getCode).collect(Collectors.toList())));
        vehicleCodes.removeAll(vehicleCodesRepository.findAllById(vehicleCodes.stream()
                .map(VehicleCodesEntity::getVehicleCodeKey).collect(Collectors.toList())));
    }
}
