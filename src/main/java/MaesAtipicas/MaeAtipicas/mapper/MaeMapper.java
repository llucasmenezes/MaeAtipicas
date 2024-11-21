package MaesAtipicas.MaeAtipicas.mapper;

import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import MaesAtipicas.MaeAtipicas.model.AddressModel;
import MaesAtipicas.MaeAtipicas.model.MaeModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MaeMapper {

    public MaeModel map(MaeDTO maeDTO) {
        MaeModel maeModel = new MaeModel();
        maeModel.setId(maeDTO.getId());
        maeModel.setName(maeDTO.getName());
        maeModel.setLastName(maeDTO.getLastName());
        maeModel.setCpf(maeDTO.getCpf());
        maeModel.setAdressModel(maeDTO.getAddressModel());
        return maeModel;
    }

    public MaeDTO map(MaeModel maeModel){
        MaeDTO maeDTO = new MaeDTO();
        maeDTO.setId(maeModel.getId());
        maeDTO.setName(maeModel.getName());
        maeDTO.setLastName(maeModel.getLastName());
        maeDTO.setCpf(maeModel.getCpf());
        maeDTO.setAddressModel(maeDTO.getAddressModel());
        return maeDTO;
    }
}
