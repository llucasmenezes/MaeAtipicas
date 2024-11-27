package MaesAtipicas.MaeAtipicas.controller;

import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import MaesAtipicas.MaeAtipicas.service.MaeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("maes/ui")
public class MaeControllerUi {

    private final MaeService maeService;

    public MaeControllerUi(MaeService maeService){
        this.maeService = maeService;
    }


    @GetMapping("/listar")
    public String getAll(Model model) {
        List<MaeDTO> maes = maeService.getAll();
        model.addAttribute("maes", maes);
        return "listarMaes";
    }




}
