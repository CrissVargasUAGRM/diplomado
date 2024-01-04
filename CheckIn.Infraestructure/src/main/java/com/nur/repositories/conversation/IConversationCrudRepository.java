package com.nur.repositories.conversation;

import com.nur.model.ConversationJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConversationCrudRepository extends JpaRepository<ConversationJpaModel, UUID> {}
