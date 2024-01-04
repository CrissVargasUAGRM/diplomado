package com.nur.repositories.commend;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CommendPerson;
import com.nur.model.CommendPersonJpaModel;
import com.nur.repositories.ICommendPersonRepository;
import com.nur.utils.CommendPersonUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;

public class CommendPersonCrudRepositoryImpl implements ICommendPersonRepository {

  @Autowired private ICommendPersonCrudRepository commendPersonCrudRepository;

  @Override
  public UUID update(CommendPerson commend) throws BusinessRuleValidationException {

    CommendPerson commendsPerson =
        new CommendPerson(
            commend.getUserId(),
            commend.getValoration(),
            commend.getCommend(),
            commend.getPerson(),
            commend.getPoints());
    CommendPersonJpaModel model = CommendPersonUtils.commendToJpaEntity(commendsPerson);

    return commendPersonCrudRepository.save(model).getId();
  }

  @Override
  public CommendPerson getById(UUID id) {
    try {
      CommendPersonJpaModel jpaModel = commendPersonCrudRepository.findById(id).orElse(null);
      if (jpaModel == null) return null;
      return CommendPersonUtils.paToCommendPerson(jpaModel);
    } catch (BusinessRuleValidationException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<CommendPerson> getAll() {
    List<CommendPersonJpaModel> jpaModels =
        Streamable.of(commendPersonCrudRepository.findAll()).toList();
    List<CommendPerson> commends = new ArrayList<>();
    jpaModels.stream()
        .forEach(
            item -> {
              try {
                commends.add(CommendPersonUtils.paToCommendPerson(item));
              } catch (BusinessRuleValidationException e) {
                throw new RuntimeException(e);
              }
            });
    return commends;
  }

  public void setCommendPersonCrudRepository(
      ICommendPersonCrudRepository commendPersonCrudRepository) {
    this.commendPersonCrudRepository = commendPersonCrudRepository;
  }
}
