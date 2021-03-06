package ru.simbirsoft.projecttaskboard.dto;

import org.springframework.stereotype.Component;
import ru.simbirsoft.projecttaskboard.entity.Version;

import java.time.LocalDate;


@Component("VersionComponent")
public class VersionDTO {
    private LocalDate startDate;
    private LocalDate endDate;


    public static VersionDTO from(Version version) {
        VersionDTO versionDTO = new VersionDTO();
        versionDTO.setStartDate(version.getDateStart());
        versionDTO.setEndDate(version.getDateEnd());
        return versionDTO;
    }

    public Version toVersion() {
        Version version = new Version();
        version.setDateStart(this.startDate);
        version.setDateEnd(this.endDate);
        return version;
    }


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
