package MaesAtipicas.MaeAtipicas.mapper;

import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import MaesAtipicas.MaeAtipicas.model.MaeModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface MaeMapper {

   MaeModel map(MaeDTO maeModel);
   MaeDTO map(MaeModel maeModel);
}
