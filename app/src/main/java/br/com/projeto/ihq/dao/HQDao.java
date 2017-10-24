package br.com.projeto.ihq.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.ihq.model.HQ;

public class HQDao {
    private static List<HQ> hqs = new ArrayList<>();

    public void addHQ(HQ hq) {
        hqs.add(hq);
    }

    public void removeHQ(int id) {
        for (int i = 0; i < hqs.size(); i++) {
            if (hqs.get(i).getId() == id) {
                hqs.remove(i);
                break;
            }
        }
    }

    public HQ getHQ(int id) {
        for (int i = 0; i < hqs.size(); i++) {
            if (hqs.get(i).getId() == id) {
                return hqs.get(i);
            }
        }
        return null;
    }

    public List<HQ> getHqs() {
        return hqs;
    }
}
