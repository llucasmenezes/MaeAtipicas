package MaesAtipicas.MaeAtipicas.controller;
import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import MaesAtipicas.MaeAtipicas.model.MaeModel;
import MaesAtipicas.MaeAtipicas.service.MaeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("mae/ui")
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

    @GetMapping("/deletar/{id}")
    public String deleteMaeById(@PathVariable Long id) {
        maeService.deleteMae(id);
        return "redirect:/mae/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String getMaeById(@PathVariable Long id, Model model) {
        Optional<MaeDTO> mae = maeService.getMaeById(id);

        if (!mae.isPresent()) {
            model.addAttribute("mensagem", "QUE PENA :(... Mãe não encontrada");
            return "listarMaes";
        }

        MaeDTO maeDTO = mae.get();

        if (maeDTO.getAddressModel() != null) {
            model.addAttribute("endereco", maeDTO.getAddressModel());
        } else {
            model.addAttribute("mensagemEndereco", "Endereço não disponível");
        }

        model.addAttribute("mae", maeDTO);
        return "detalhesMae";
    }



    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("mae", new MaeDTO());
        return "adicionarMae";
    }

    @PostMapping("/salvar")
    public String createMae(@RequestBody MaeDTO mae, RedirectAttributes redirectAttributes) {
        maeService.createMae(mae);
        redirectAttributes.addFlashAttribute("mensagem", "EBAA MAEE! seu cadastro foi concluido com sucesso. :)" );
        return "redirect:mae/ui/listar";
    }




}
