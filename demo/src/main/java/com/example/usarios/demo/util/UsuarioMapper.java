package com.example.usarios.demo.util;

import java.util.List;
import java.util.stream.Collectors;
import com.example.usarios.demo.model.UsuarioDTO;
import com.example.usarios.demo.model.UsuarioVO;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(UsuarioVO vo) {
        if (vo == null) {
            return null;
        }
        return UsuarioDTO.builder()
                .id(vo.getId())
                .nombre(vo.getNombre())
                .apellido(vo.getApellido())
                .calle(vo.getCalle())
                .codPostal(vo.getCodPostal())
                .ciudad(vo.getCiudad())
                .cumpleanos(vo.getCumpleanos())
                .tutorialIds(vo.getTutorialIds()) // 🔹 Mapear tutorialIds
                .build();
    }

    public static UsuarioVO toVO(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }
        return UsuarioVO.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .calle(dto.getCalle())
                .codPostal(dto.getCodPostal())
                .ciudad(dto.getCiudad())
                .cumpleanos(dto.getCumpleanos())
                .tutorialIds(dto.getTutorialIds()) // 🔹 Mapear tutorialIds
                .build();
    }

    public static List<UsuarioDTO> toDTOList(List<UsuarioVO> voList) {
        if (voList == null) {
            return null;
        }
        return voList.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
    }

    public static List<UsuarioVO> toVOList(List<UsuarioDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return dtoList.stream().map(UsuarioMapper::toVO).collect(Collectors.toList());
    }
}
