function validarForma (forma){

    // Comprobar el campo username
    var usuario = forma.ldapUsername;
    if(usuario.value == ""){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }

    // Comprobar el campo password
    var password = forma.ldapPassword;
    if (password.value == ""){
        alert("Debe proporcionar  una contraseña");
        password.focus();
        password.select();
        return false;
    }

    // El formulario es valido
    alert("Formulario valido, enviando datos al servidor");
    return true;
}