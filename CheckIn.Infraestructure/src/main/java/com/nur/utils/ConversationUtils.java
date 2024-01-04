package com.nur.utils;

import com.nur.model.Conversacion;
import com.nur.model.ConversationJpaModel;

public class ConversationUtils {
  public static ConversationJpaModel conversationToJpaEntity(Conversacion conversacion) {
    ConversationJpaModel model = new ConversationJpaModel();
    model.setId(conversacion.getId());
    model.setInitDate(conversacion.getFechaInicio());
    model.setEndDate(conversacion.getFechaFin());
    model.setStatusConversation(conversacion.getStatus().name());
    return model;
  }

  public static Conversacion jpaToConversation(ConversationJpaModel jpaModel) {
    return new Conversacion(jpaModel.getId(), jpaModel.getInitDate());
  }
}
