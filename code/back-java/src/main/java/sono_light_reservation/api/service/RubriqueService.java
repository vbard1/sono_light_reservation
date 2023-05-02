package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.RubriqueDto;
import sono_light_reservation.api.entity.Rubrique;
import sono_light_reservation.api.repository.RubriqueRepository;
import sono_light_reservation.api.service.mapper.RubriqueMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public
class RubriqueService {
    @Autowired
    private RubriqueRepository rubriqueRepository;

    @Autowired
    private RubriqueMapper rubriqueMapper;

    /**
     * Lire les details d'une rubrique par son id
     * @param id
     * @return rubrique
     */
    public Optional<RubriqueDto> getRubrique(final Long id) {
        Optional<Rubrique> rubrique = rubriqueRepository.findById(id);
        RubriqueDto rubriqueDto = rubriqueMapper.convertToDto(rubrique);
        return Optional.ofNullable(rubriqueDto);
    }

    /**
     * Liste de toutes les rubriques
     * @return la liste de toutes les rubriques
     */
    public List<RubriqueDto> getRubriques() {
        return ((List<Rubrique>) rubriqueRepository.findAll()).stream().map(rubrique -> rubriqueMapper.convertToDto(Optional.ofNullable(rubrique))).collect(Collectors.toList());
    }

    public RubriqueDto saveRubrique(RubriqueDto rubriqueDto) {
        Rubrique rubrique = rubriqueMapper.convertToEntity(rubriqueDto);
        rubriqueRepository.save(rubrique);
        return rubriqueMapper.convertToDto(Optional.of(rubrique));
    }

    /**
     * Supprimer une rubrique existante
     * @param id
     * @return String: confirmation de suppression
     */
    public String deleteRubrique(final Long id) {
        rubriqueRepository.deleteById(id);
        if (rubriqueRepository.findById(id).isEmpty()) {
            return "rubrique supprimée";
        } else {
            return "Erreur dans la suppression";
        }
    }

    /**
     * Modifier les details d'une rubrique par son id
     * @param id
     * @param updatedRubrique
     * @return rubrique avec les modifications
     */
    public RubriqueDto updateRubrique(Long id, RubriqueDto updatedRubrique) {
        Rubrique rubrique = rubriqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id rubrique invalide:" + id));
        if (updatedRubrique.getLibelle() != null) {
            rubrique.setLibelle(updatedRubrique.getLibelle());
        }
        return rubriqueMapper.convertToDto(Optional.of(rubriqueRepository.save(rubrique)));
    }
}