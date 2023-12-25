package com.kreit.movein.dto;

public record FilterCardSuggestionConsultationDto(
        Integer filterCardId,
        Boolean didSuggestAlready,
        Boolean isConsultationRequested
) {
}
