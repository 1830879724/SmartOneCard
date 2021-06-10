package com.cykj.service;

import com.cykj.bean.MenuToal;

import java.util.List;
import java.util.Map;

public interface MenuService {
    public Map<String, List<MenuToal>> findMenuByRole(String role, Integer fid);

}
