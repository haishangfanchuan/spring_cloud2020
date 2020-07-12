package top.theonecyl.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
//@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> implements Serializable{

    private Integer status;
    private String message;
    private T       date;

    public CommentResult(Integer status, String message) {
       this(status,message,null);
    }

    public CommentResult(Integer status, String message, T date) {
        this.status = status;
        this.message = message;
        this.date = date;
    }
}
