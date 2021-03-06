package com.gogo.GoGo.service;

import com.gogo.GoGo.controller.dto.community.CommunityDto;
import com.gogo.GoGo.domain.community.Community;
import com.gogo.GoGo.repository.community.CommunityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CommunityServiceTests {

    @InjectMocks
    public CommunityService communityService;

    @Mock
    private CommunityRepository communityRepository;

    @Test
    public void create(){
        CommunityDto dto = CommunityDto.builder()
                .title("훗카이도로 가자")
                .content("훗카이도 2박3일 한분 구합니다")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();

        communityService.create(dto,1L,"Yboy");

        verify(communityRepository).save(argThat(new IsCommunityWillBeInserted()));

    }

    private static class IsCommunityWillBeInserted implements ArgumentMatcher<Community> {

        CommunityDto dto = CommunityDto.builder()
                .title("훗카이도로 가자")
                .content("훗카이도 2박3일 한분 구합니다")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();

        @Override
        public boolean matches(Community community) {
            return equals(community.getTitle(),"훗카이도로 가자")
                    && equals(community.getContent(),"훗카이도 2박3일 한분 구합니다")
                    && equals(community.getStartDate(),LocalDate.now())
                    && equals(community.getEndDate(),LocalDate.now())
                    && equals(community.getUserId(),1L)
                    && equals(community.getCreatedBy(),"Yboy");
        }
        private boolean equals(Object actual, Object expected){
            return expected.equals(actual);
        }
    }

}