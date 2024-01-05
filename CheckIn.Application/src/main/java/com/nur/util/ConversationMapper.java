package com.nur.util;

import com.nur.dtos.ConversationDTO;
import com.nur.model.Conversacion;
import java.util.UUID;

public class ConversationMapper {
  public static ConversationDTO from(Conversacion conversation) {
    if (conversation == null) return new ConversationDTO();
    return new ConversationDTO(
        String.valueOf(conversation.getId()),
        conversation.getFechaInicio(),
        conversation.getFechaFin(),
        conversation.getStatus().name());
  }

  public static Conversacion from(ConversationDTO conversation) {
    return new Conversacion(UUID.fromString(conversation.getId()), conversation.getInitDate());
  }
}
