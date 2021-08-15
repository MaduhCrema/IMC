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
## **Ciclo de vida**
- É a criação, interrupção ou retomada de uma tela ou a destruição do processo pelo sistema
- Por exemplo onCreate(), onResume
()
- É um ciclo visível ou invisível.
- É como se fosse varias funções "main"

***EXEMPLO***
![imagem](https://dariomungoi.files.wordpress.com/2015/01/basic-lifecycle.png)
- **onCreat()**, você prepara  a tela
- **onStart()**, você coloca os elementos visuais da tela
- **onResume()**, agora o usuário podera interagir com a tela
- **onPause()**, o usuário pausa a tela. que ainda está visível, na interação que ele parou
- **onStop()**, quando a tela não está mais interativa a aplicação para.
- **onRestart**, quando o usuário que voltar para a tela depois o onStop
- **onDestroy()**, encerra o ciclo, e quando retorna na aplicação um novo ciclo começa
- **finish()**, se utilizar essa função dentro de algum ciclo, ele finaliza o ciclo.

## **Gradle**
***Configura e automatiza a build/compilação***
- **Build.gradle** é o arquivo de configuração
## **Construção de telas**
## **Layout**
- É uma construção de interface de usuário
![IMAGEM](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/images/1_2_C_images/dg_common_layouts_visual_rep.png)
- ViewBinding

### **Layout XML**
- Constroi a aplicação com linguagem XML
- Organizado por ordem de Parent

### **Tipos de Layout**
**Linear Layout**
- itens alinhados um após o outro horizonalmente ou verticalmente
- Elementos não serão sobreposto

## **Views**
- Todo  component é uma view e toda view é clicável, se for associado alguma função, se não será uma view estática
- Views herdam métodos, aparência, estilo e atributos de component, ou podem ser criados de maneira costumizada

***Hierarquia das views***
![imagem](https://4.bp.blogspot.com/-r7fkm4ahE1Y/WrCl9dFfGsI/AAAAAAAAQ-8/7sbIuWZ69TY-dn_Y4zYkDresu_XRLr7uACLcBGAs/s1600/cautrucview.png)

#### **Atributos**
- Gravity = Como será a gravidade dos componentes na tela, de forma geral, ou seja de pai para filho
- Layout Gravity = Manipula a forma horizontal,vertical,esquerda ou direita, a forma qu eo filho se comportará no pai
-----------------
- Margin =  Distância do componente da borda do lado de fora
- Padding = Distância do componente da borda do lado de dentro
![imagem](https://i.stack.imgur.com/6IbSe.png)
----------------
- **InputType** = É para especificar o tipo de teclaod para a entrada
- **Match_parent** = É uma propriedade que define o tamanho (altura ou largura) da view baseado no seu conteúdo, usando o máximo possível de espaço
- **Wrap_parent** =  É uma propriedade que define o tamanho (altura ou largura) da view baseado no seu conteúdo, usando o mínimo possível de espaço
- **dp** = Essa unidade é relativa à resolução da tela. Por exemplo se a resolução da tela é de 160 dpi, significa que um dp representa 1 pixel em um total de 160. USO: aconselho ao invés de usar o px sempre use o dp
- **sp** =  Idem ao dp, mas também considera o tamanho da fonte que o usuário está utilizando. É recomendado que use essa unidade quando especificar o tamanho de uma fonte, para que esta seja automaticamente ajustada conforme as preferências da tela do usuário. USO: Sempre utilize sp para fontes!
### **Ícones**
- Pode ser alterado na pasta mipmap
### **strings.xml**
- Local de armazenamento das frases usadas na aplicação
### **themes.xml**
- Cores usadas no tema da aplicação,
