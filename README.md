# retries-demo

- O que é retry?
- Quando usar retry?
- Estratégis de retry
  - FeignCLient.Retryer
  - Resilience4J.Retry
  - Spring.Retry
  - Retry externalizado:
    - Gateway
    - Sidecar
    - Mensageria (NACK e reprocessamento)
- Preocupações quando se usa retry
  - Retry storm
  - Idempotênce

## Contexto 

Quando falamos de APIs e sistemas distribuídos em geral, uma certeza que podemos ter é que redes falham.
Além de falhas na rede, podem ocorrer falhas em serviços interdependentes, quebrando o fluxo de uma execução.

### O que é retry?

Retry é um mecanismo que monitora uma execução e na detecção de falha, dispara automaticamente uma repetição da mesma solicitação.
Este conceito se aplica à uma request por um microserviço, uma solicitação de upload de arquivo no BlobStorage, o envio de uma mensagem para um broker etc.

### Quando usar retry?

No entanto um retry só deve ser executado quando houver uma chance de sucesso.
Num contexto HTTP por exemplo, de forma geral só devemos considerar o uso de retries nas respostas http como HTTP_STATUS da faixa 5XX. Pois estes indicam um falha do lado do servidor. (com exceção ao erro 501)
| Code | Name | Retryable |
| --- | --- | --- |
| 500 | Internal Server Error | Sim | generic error message, given when an unexpected condition was encountered and no more specific message is suitable.
| 501 | Not Implemented | Não |
| 502 | Bad Gateway | Sim |
| 503 | Service Unavailable | Sim |
| 504 | Gateway Timeout | |Sim |

Já erros da faixa 4XX por sua vez, indicam um problema na request, ou seja, um erro do lado do cliente que está fazendo a solicitação. E por isto não devem ser executados retries. 

| Code | Name | Retryable |
| --- | --- | --- |
| 400 | Bad Request | Não |
| 401 | Unauthorized | Não |
| 403 | Forbidden | Não |
| 404 | Not Found | Não |
| 409 | Conflict | Não |

## Como executar retry

### FeignCLient.Retryer

### Resilience4J.Retry
### Spring.Retry

### Retry externalizado:

#### Gateway

#### Sidecar
    
#### Mensageria (NACK e reprocessamento)
