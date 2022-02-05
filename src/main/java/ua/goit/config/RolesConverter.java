package ua.goit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.goit.dto.RolesDto;
import ua.goit.services.RolesService;

import java.util.UUID;

@Component
public class RolesConverter implements Converter<String, RolesDto> {

    @Autowired
    private RolesService roleService;

    @Override
    public RolesDto convert(String source) {
        return roleService.get(UUID.fromString(source));
    }
}
