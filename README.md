# simian
Teste prático Mercado livre.

## API REST

Serviço rest para trazer a quantidade de DNA’s símios, quantidade de DNA’s humanos, e a proporção de símios para a população humana.

 - Exemplo: 
```sh
GET /stats HTTP/1.1
Host: simion.herokuapp.com
```

Serviço rest para verificar se o DNA é humano ou mutante. 

```sh
POST /simian HTTP/1.1
Host: simion.herokuapp.com
Content-Type: application/json

{
"dna": ["ATGCGA", "CAGTGC", "TTAGTT", "AGACGG", "GCGTCA", "TCACTC"]
}
```

Código HTTP.

Para DNA Humano:
```sh
403 Forbidden 
```

Para DNA Mutante (Simian):
```sh
200 Ok 
```
