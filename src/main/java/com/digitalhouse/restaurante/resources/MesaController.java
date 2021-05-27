package com.digitalhouse.restaurante.resources;

import com.digitalhouse.restaurante.domain.Mesa;
import com.digitalhouse.restaurante.domain.Pedido;
import com.digitalhouse.restaurante.domain.Prato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    private List<Mesa> mesas = new ArrayList<>();
    private Double caixa = 0.0;

    public MesaController(){
        Prato p1 = new Prato(0,10.99,"Macarrão",3);
        Prato p2 = new Prato(1,30.99,"Feijoada",1);
        Prato p3 = new Prato(2,4.99,"Coca",6);

        Pedido ped1 = new Pedido(0,null);
        Pedido ped2 = new Pedido(1,null);

        Mesa m1 = new Mesa(0);

        ped1.getPratos().addAll(Arrays.asList(p1,p2));
        ped2.getPratos().add(p3);

        ped1.setMesa(m1);
        ped2.setMesa(m1);

        m1.getPedidos().addAll(Arrays.asList(ped1,ped2));

        this.mesas.add(m1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getPedidos(@PathVariable Integer id){
        Mesa mesa = mesas.stream().filter(m -> m.getId() == id).findFirst().get();

        return ResponseEntity.ok().body(mesa);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> fecharMesa(@PathVariable Integer id){
        Mesa mesa = mesas.stream().filter(m -> m.getId() == id).findFirst().get();
        caixa += mesa.getTotalConsumido();
        mesa.getPedidos().clear();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/caixa")
    public ResponseEntity<Double> getValorCaixa(){
        return ResponseEntity.ok().body(this.caixa);
    }

}
