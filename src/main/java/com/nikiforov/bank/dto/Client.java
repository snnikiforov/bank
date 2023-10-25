package com.nikiforov.bank.dto;


import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class Client {
    private Long id;
    private String fio;
    private String userName;
    private String eMail;
    private String password;

    public String GetHashPassword()
    {
        return  Hashing.sha256().hashString(this.userName+this.password, Charsets.UTF_8).toString();
    }






}
