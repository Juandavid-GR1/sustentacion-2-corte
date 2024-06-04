import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.sustentacion.cerveza.Domain.Cerveceria;
import com.sustentacion.cerveza.service.CervezaService;

@Service
public class CerveceriaServiceImp  implements CervezaService {
    private final ArrayList<Cerveceria> cerveceria = new ArrayList<>();

    @Override
    public ArrayList<Cerveceria> listaCervecerias(){
        if(cerveceria == null)
            return new ArrayList<>();
        return cerveceria;
    }

    @Override
    public void GuardarCerveceria(Cerveceria cerveceria){
        cerveceria.add(new Cerveceria());
    }

    @Override
    public Cerveceria MostrarCerveceria(String nombre){
        return cerveceria.stream().filter(cerveceria -> cerveceria.getNombre_cerveceria().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}