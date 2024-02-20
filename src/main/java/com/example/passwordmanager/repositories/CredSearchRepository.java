package com.example.passwordmanager.repositories;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.passwordmanager.dto.CredentialsDtoSafe;
import co.elastic.clients.elasticsearch.core.search.Hit;

import com.example.passwordmanager.models.Credential;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CredSearchRepository  {

    private final ElasticsearchClient elasticsearchClient;

    @SneakyThrows
    public void index(final CredentialsDtoSafe credential) {
        final IndexRequest<CredentialsDtoSafe> request = new IndexRequest.Builder<CredentialsDtoSafe>()
                .index("users_1")
                .document(credential)
                .build();
        elasticsearchClient.index(request);
    }

    @SneakyThrows
    public List<Long> findByDescription(final String description) {
        final SearchRequest request = new SearchRequest.Builder()
                .query(new Query.Builder()
                        .multiMatch(new MultiMatchQuery.Builder()
                                .query(description)
                                .fields("name", "website")
                                .build())
                        .build())
                .build();
        SearchResponse<CredentialsDtoSafe> search = elasticsearchClient.search(request, CredentialsDtoSafe.class);
        return search.hits().hits()
                .stream()
                .map(Hit::source)
                .filter(Objects::nonNull)
                .map(CredentialsDtoSafe::getId)
                .collect(Collectors.toList());
    }
}
