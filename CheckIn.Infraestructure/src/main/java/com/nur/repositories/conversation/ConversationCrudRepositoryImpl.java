package com.nur.repositories.conversation;

import com.nur.model.Conversacion;
import com.nur.model.ConversationJpaModel;
import com.nur.repositories.IConversationRepository;
import com.nur.utils.ConversationUtils;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class ConversationCrudRepositoryImpl implements IConversationRepository {

  @Autowired private IConversationCrudRepository conversationCrudRepository;

  @Override
  public UUID update(Conversacion conversation) {
    Conversacion conversacion = new Conversacion();
    ConversationJpaModel model = ConversationUtils.conversationToJpaEntity(conversacion);
    return conversationCrudRepository.save(model).getId();
  }

  @Override
  public Conversacion delete(UUID id) {
    return null;
  }
}
