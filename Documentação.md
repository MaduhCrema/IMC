## Modo desenvolvedor no Android Studio
### *tranforma o aparelho em modo de teste para os aplicativos.*
*Debug*  =
Compila passo a passo a aplicação

*ADB* = Conjunto de operações para o modo debug, para aparelho físico.(ADB idea)- plugin

*Breakpoint* =
você escolhe a onde para na aplicação
*Layout inspector* =  Analisa o layout do aplicativo

## **Logs**
### **Logcat**
O Logcat é uma ferramenta de linha de comando que despeja um registro de mensagens do sistema, incluindo stack traces, quando o dispositivo gera um erro e mensagens que você escreveu no app com a classe Log.
### **Tipos de log**
- DEBUG- log.
- ERROR-log.e
- INFO-log.i
- VERBOSE-log.v
- WARNING-log.w
### *Exemplo*
*Poder agrupar tags do mesmo tipo ---       mensagem do log*
Log.W("w/EmpityField","O campo não foi preenchido")

*saiba mais* =
https://developer.android.com/studio/command-line/logcat?hl=pt-br
## **Erros e exceptions**
- *ANRs* = app não responde, falta de  retorno na interação com o usuário, bloqueio da UI  thread, fechamento do app.
- *Throwable* = Superclasse de erros e exceptions. As subclasse são Erros, que ocorrem na execução e compilação, e exceptions , que quebram na aplicação(crash).

## **Criando um projeto no Android-Studio**
*Exemplo de projeto*
![imagem](https://miro.medium.com/max/310/1*Kkxy5g1smXCTCxeY8zta6A.png)

**Minimum SDK** = versão mínima que seu App irá rodar
### **Manifest**
* É um relatório que apresenta todos os elmentos e funções da sua aplicação.
* Possui declarações das activities e as permissões do app.
* Declarado por tags.
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.maduh.imcapplication">

    <application
        android:allowBackup="true"
        *ícone*
        android:icon="@mipmap/ic_launcher" 
        *nome do app*
        android:label="@string/app_name"
        *formaot do icone*
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        *tema do app*
        android:theme="@style/Theme.Imcapplication">
        *tela principal*
        <activity 
        *modo de tela do app, no caso retrato*
        android:screenOrientation="portrait"
        android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category
                *primeira tela que o usuário irá ver ao entrar no app
                 android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
## **MainActivity**
**A activity instância métodos callback ciclo de vida, ao invez de ser so uma função main, e possui uma ou mais tela**
- toda activity deve ser declarada no manifest 
- o layout da activity define o que o usuário verá, além de gerenciar ciclo de vida, interaçõe socm o usuário, abertura de outras telas e et.
```kt
package com.maduh.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    //função onde criar a nossa tela,ou ciclo de vida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //vai setar(mostrar) a view 
        setContentView(R.layout.activity_main)
    }
}
```