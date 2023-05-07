package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.EvenementDto;
import sono_light_reservation.api.entity.Evenement;
import sono_light_reservation.api.repository.EvenementRepository;
import sono_light_reservation.api.service.mapper.EvenementMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private EvenementMapper evenementMapper;

    /**
     * Lire les details d'un évènement par son id
     * @param id
     * @return evenementDto
     */
    public EvenementDto getEvenement(Long id) {
        Optional<Evenement> evenement = evenementRepository.findById(id);
        EvenementDto evenementDto = evenementMapper.convertToDto(evenement);
        return evenementDto;
    }

    /**
     * Liste de tous les évènements
     * @return La liste de tous les évènements
     */
    public List<EvenementDto> getEvenements() {
        return ((List<Evenement>) evenementRepository.findAll()).stream().map(evenement -> evenementMapper.convertToDto(Optional.ofNullable(evenement))).collect(Collectors.toList());
    }
}
