package lk.ijse.spring.service;

import lk.ijse.spring.dto.Super_DTO;
import lk.ijse.spring.response.Response;

public interface SuperService<T extends Super_DTO, ID> {
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
