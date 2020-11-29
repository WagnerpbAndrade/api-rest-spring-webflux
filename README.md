# API REST com Spring Webflux

O spring MVC, assim como vários outros Frameworks Java trabalha com Servlets, que trabalha ou de modo síncrono (versão anterior ao Servlet 3), ou de modo assíncrono (Servlet 3+). Esse modelo trabalha utilizando um pool de thread cacheado e limitado (exemplo, máximo de 50 threads), e a cada nova requisição uma dessas threads é alocada para processar a requisição. <br>

No Spring Webflux, o servidor Web nao é mais convencional (como tomcat), ao invés, usam o Netty, que possui uma implementação de Servidor com suporte à Non-blocking IO. Non-blocking IO é assíncrono mas nem tudo que é assíncrono é Non-blocking IO, e essa é uma confusão que muita gente comete. Com IO bloqueante, uma thread fica sempre esperando pela resposta do IO (mesmo que não seja a thread que estava processando a requisição), enquanto no Non-blocking IO, uma thread tem a capacidade de tratar várias chamadas IO ao mesmo tempo sem bloquear (isso pode ser visto na api NIO2, porém os conceitos são baseados em Selector, Channel e Buffers, que são conceitos existentes no Sistema Operacional). <br>

### Ferramentas <br>
> Intellij Idea (IDE)<br>
> MongoDB Cloud (Database NoSql, orientado a documentos)<br>
> Insomnia (Testar end-points)<br>

### Créditos
> Michelli Brito
