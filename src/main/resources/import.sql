-- role
insert into role(id, name) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'ROLE_USER');
insert into role(id, name) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', 'ROLE_STATS');
insert into role(id, name) values ('4d0f7301-c123-4189-9636-066531275bf4', 'ROLE_DEV');
insert into role(id, name) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'ROLE_ADMIN');

-- authority
-- USER
-- general
insert into authority(id, name) values ('10f91826-fe13-412f-93af-d7d6c9114bb0', 'USER_READ');
insert into authority(id, name) values ('2f3ad512-b4a6-41bb-aba6-31ebca52062e', 'USER_WRITE');
insert into authority(id, name) values ('08626633-5087-45df-ab05-407b5e5bf09c', 'USER_UPDATE');
insert into authority(id, name) values ('33453411-ad41-4c68-8217-e3d9e52c8ab6', 'USER_DELETE');

-- stats
insert into authority(id, name) values ('1b0c7bee-768e-4565-8cf0-dcc2ab0e708f', 'USER_READ_STATS');

-- AUTHORIZATION
-- general
insert into authority(id, name) values ('6721915c-88ef-4de5-84aa-fcefde1deb79', 'AUTHORIZATION_READ');
insert into authority(id, name) values ('9561a620-7a23-4718-b075-e94b71f1f344', 'AUTHORIZATION_WRITE');
insert into authority(id, name) values ('45ac8248-1416-4c5a-8636-b35dab608dc1', 'AUTHORIZATION_UPDATE');
insert into authority(id, name) values ('87f1e448-4335-4815-96b8-0e7d705bb2f2', 'AUTHORIZATION_DELETE');

-- stats
insert into authority(id, name) values ('167c8883-2af4-4f13-bb65-5d45818050e6', 'AUTHORIZATION_READ_STATS');

-- RANK
-- general
insert into authority(id, name) values ('ed733067-4677-4d08-b35d-5c5e652508f2', 'RANK_READ');
insert into authority(id, name) values ('0e7232fe-d06b-4c8c-8c58-eb9a00f64ab9', 'RANK_WRITE');
insert into authority(id, name) values ('16de1a45-598a-4755-878a-2b0f4b35b8b4', 'RANK_UPDATE');
insert into authority(id, name) values ('49c5696e-dded-4b9d-9940-729c627b6320', 'RANK_DELETE');

-- stats
insert into authority(id, name) values ('485df68b-6a91-45a9-8e8c-faf89811c5de', 'RANK_READ_STATS');

-- ORDER
-- general
insert into authority(id, name) values ('f46e5829-a674-4b8c-9ab1-6a91827a297b', 'ORDER_READ');
insert into authority(id, name) values ('fd9f1a75-ff55-4248-b585-4b37c0c1b834', 'ORDER_WRITE');
insert into authority(id, name) values ('aac3e617-d2f1-49cf-9e56-3ed36711a169', 'ORDER_UPDATE');
insert into authority(id, name) values ('b4b705ab-6174-4701-8297-0943d3abe914', 'ORDER_DELETE');

-- own
insert into authority(id, name) values ('c26052d4-3b4d-496d-8411-f542fc6b5dd1', 'ORDER_READ_OWN');

-- stats
insert into authority(id, name) values ('1d5acc3b-0482-4c68-99a2-4d8b1b46d0f3', 'ORDER_READ_STATS');

-- STATUS
-- general
insert into authority(id, name) values ('bd8d3562-a21c-48fc-b689-740cd74773e3', 'STATUS_READ');
insert into authority(id, name) values ('53b740c4-90b5-4806-b32c-df3d3b836bf3', 'STATUS_WRITE');
insert into authority(id, name) values ('0f087d83-8c45-4558-bb0b-b899faf31b4f', 'STATUS_UPDATE');
insert into authority(id, name) values ('c0f40df9-ae59-4c7d-822b-2673ada940db', 'STATUS_DELETE');

-- stats
insert into authority(id, name) values ('4b931a5e-3560-4e91-b15e-7088e982e474', 'STATUS_READ_STATS');

-- TEA
-- general
insert into authority(id, name) values ('5983f4e7-4db9-443b-800e-c455e549b250', 'TEA_READ');
insert into authority(id, name) values ('057cda2e-7be6-417e-b036-aa3b3897a0af', 'TEA_WRITE');
insert into authority(id, name) values ('fc8eb9e6-05cd-4e72-9c53-08bc439dfbf6', 'TEA_UPDATE');
insert into authority(id, name) values ('f242b45e-7d76-433d-b702-4c1210af36d3', 'TEA_DELETE');

-- stats
insert into authority(id, name) values ('17ec9b8d-454e-4daf-8ac9-23e1fbd7be27', 'TEA_READ_STATS');

-- TEATYPE
-- general
insert into authority(id, name) values ('3a819bbe-78f8-4488-aa52-6c39772f5a34', 'TEATYPE_READ');
insert into authority(id, name) values ('e55bb666-83be-4c49-b7ff-37efd484361d', 'TEATYPE_WRITE');
insert into authority(id, name) values ('c3d64a39-8773-4d49-ad51-f96b8eb23687', 'TEATYPE_UPDATE');
insert into authority(id, name) values ('96c58bb9-615f-45d2-8f81-bab918ec3ef5', 'TEATYPE_DELETE');

-- stats
insert into authority(id, name)
values ('b6a2001b-97cc-424f-8dd9-e5702374a172', 'TEATYPE_READ_STATS');

-- COUNTRY
-- general
insert into authority(id, name) values ('1d3cd702-a6b1-41f2-8361-8b08bbf4828c', 'COUNTRY_READ');
insert into authority(id, name) values ('859cf686-72d6-4eb7-bd34-c96c0ab0be66', 'COUNTRY_WRITE');
insert into authority(id, name) values ('1b63b752-2de3-47f7-acd8-c2ca3bc2a220', 'COUNTRY_UPDATE');
insert into authority(id, name) values ('00b5ed19-ed3a-4997-94a7-8069ffa9ae58', 'COUNTRY_DELETE');

-- stats
insert into authority(id, name) values ('140d24d6-9095-4ee1-b0dd-a9bd7ed976fa', 'COUNTRY_READ_STATS');

-- roles authorities
-- USER
-- ROLE_USER
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '10f91826-fe13-412f-93af-d7d6c9114bb0');
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '2f3ad512-b4a6-41bb-aba6-31ebca52062e');
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '08626633-5087-45df-ab05-407b5e5bf09c');
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '33453411-ad41-4c68-8217-e3d9e52c8ab6');

-- ROLE_STAT
insert into roles_authorities(role_id, authority_id) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', '1b0c7bee-768e-4565-8cf0-dcc2ab0e708f');

-- ROLE_DEV
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '10f91826-fe13-412f-93af-d7d6c9114bb0');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '2f3ad512-b4a6-41bb-aba6-31ebca52062e');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '08626633-5087-45df-ab05-407b5e5bf09c');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '33453411-ad41-4c68-8217-e3d9e52c8ab6');

-- ROLE_ADMIN
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '10f91826-fe13-412f-93af-d7d6c9114bb0');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '2f3ad512-b4a6-41bb-aba6-31ebca52062e');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '08626633-5087-45df-ab05-407b5e5bf09c');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '33453411-ad41-4c68-8217-e3d9e52c8ab6');

-- AUTHORIZATION
-- ROLE_STAT
insert into roles_authorities(role_id, authority_id) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', '167c8883-2af4-4f13-bb65-5d45818050e6');

-- ROLE_DEV
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '6721915c-88ef-4de5-84aa-fcefde1deb79');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '9561a620-7a23-4718-b075-e94b71f1f344');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '45ac8248-1416-4c5a-8636-b35dab608dc1');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '87f1e448-4335-4815-96b8-0e7d705bb2f2');

-- ROLE_ADMIN
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '6721915c-88ef-4de5-84aa-fcefde1deb79');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '9561a620-7a23-4718-b075-e94b71f1f344');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '45ac8248-1416-4c5a-8636-b35dab608dc1');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '87f1e448-4335-4815-96b8-0e7d705bb2f2');

-- RANK
-- ROLE_USER
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'ed733067-4677-4d08-b35d-5c5e652508f2');

-- ROLE_STAT
insert into roles_authorities(role_id, authority_id) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', '485df68b-6a91-45a9-8e8c-faf89811c5de');

-- ROLE_DEV
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'ed733067-4677-4d08-b35d-5c5e652508f2');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '0e7232fe-d06b-4c8c-8c58-eb9a00f64ab9');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '16de1a45-598a-4755-878a-2b0f4b35b8b4');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '49c5696e-dded-4b9d-9940-729c627b6320');

-- ROLE_ADMIN
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'ed733067-4677-4d08-b35d-5c5e652508f2');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '0e7232fe-d06b-4c8c-8c58-eb9a00f64ab9');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '16de1a45-598a-4755-878a-2b0f4b35b8b4');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '49c5696e-dded-4b9d-9940-729c627b6320');

-- ORDER
-- ROLE_USER
-- general
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'fd9f1a75-ff55-4248-b585-4b37c0c1b834');

-- own
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'c26052d4-3b4d-496d-8411-f542fc6b5dd1');

-- ROLE_STAT
insert into roles_authorities(role_id, authority_id) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', '1d5acc3b-0482-4c68-99a2-4d8b1b46d0f3');

-- ROLE_DEV
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'f46e5829-a674-4b8c-9ab1-6a91827a297b');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'fd9f1a75-ff55-4248-b585-4b37c0c1b834');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'aac3e617-d2f1-49cf-9e56-3ed36711a169');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'b4b705ab-6174-4701-8297-0943d3abe914');

-- ROLE_ADMIN
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'f46e5829-a674-4b8c-9ab1-6a91827a297b');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'fd9f1a75-ff55-4248-b585-4b37c0c1b834');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'aac3e617-d2f1-49cf-9e56-3ed36711a169');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'b4b705ab-6174-4701-8297-0943d3abe914');

-- STATUS
-- ROLE_USER
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'bd8d3562-a21c-48fc-b689-740cd74773e3');

-- ROLE_STAT
insert into roles_authorities(role_id, authority_id) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', '4b931a5e-3560-4e91-b15e-7088e982e474');

-- ROLE_DEV
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'bd8d3562-a21c-48fc-b689-740cd74773e3');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '53b740c4-90b5-4806-b32c-df3d3b836bf3');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '0f087d83-8c45-4558-bb0b-b899faf31b4f');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'c0f40df9-ae59-4c7d-822b-2673ada940db');

-- ROLE_ADMIN
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'bd8d3562-a21c-48fc-b689-740cd74773e3');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '53b740c4-90b5-4806-b32c-df3d3b836bf3');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '0f087d83-8c45-4558-bb0b-b899faf31b4f');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'c0f40df9-ae59-4c7d-822b-2673ada940db');

-- TEA
-- ROLE_USER
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '5983f4e7-4db9-443b-800e-c455e549b250');

-- ROLE_STAT
insert into roles_authorities(role_id, authority_id) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', '17ec9b8d-454e-4daf-8ac9-23e1fbd7be27');

-- ROLE_DEV
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '5983f4e7-4db9-443b-800e-c455e549b250');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '057cda2e-7be6-417e-b036-aa3b3897a0af');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'fc8eb9e6-05cd-4e72-9c53-08bc439dfbf6');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'f242b45e-7d76-433d-b702-4c1210af36d3');

-- ROLE_ADMIN
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '5983f4e7-4db9-443b-800e-c455e549b250');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '057cda2e-7be6-417e-b036-aa3b3897a0af');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'fc8eb9e6-05cd-4e72-9c53-08bc439dfbf6');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'f242b45e-7d76-433d-b702-4c1210af36d3');

-- TEATYPE
-- ROLE_USER
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '3a819bbe-78f8-4488-aa52-6c39772f5a34');

-- ROLE_STAT
insert into roles_authorities(role_id, authority_id) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', 'b6a2001b-97cc-424f-8dd9-e5702374a172');

-- ROLE_DEV
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '3a819bbe-78f8-4488-aa52-6c39772f5a34');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'e55bb666-83be-4c49-b7ff-37efd484361d');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'c3d64a39-8773-4d49-ad51-f96b8eb23687');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '96c58bb9-615f-45d2-8f81-bab918ec3ef5');

-- ROLE_ADMIN
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '3a819bbe-78f8-4488-aa52-6c39772f5a34');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'e55bb666-83be-4c49-b7ff-37efd484361d');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'c3d64a39-8773-4d49-ad51-f96b8eb23687');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '96c58bb9-615f-45d2-8f81-bab918ec3ef5');

-- COUNTRY
-- ROLE_USER
insert into roles_authorities(role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '1d3cd702-a6b1-41f2-8361-8b08bbf4828c');

-- ROLE_STAT
insert into roles_authorities(role_id, authority_id) values ('9b00242a-c39e-4e1d-8124-2dd926614d08', '140d24d6-9095-4ee1-b0dd-a9bd7ed976fa');

-- ROLE_DEV
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '1d3cd702-a6b1-41f2-8361-8b08bbf4828c');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '859cf686-72d6-4eb7-bd34-c96c0ab0be66');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '1b63b752-2de3-47f7-acd8-c2ca3bc2a220');
insert into roles_authorities(role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '00b5ed19-ed3a-4997-94a7-8069ffa9ae58');

-- ROLE_ADMIN
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '1d3cd702-a6b1-41f2-8361-8b08bbf4828c');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '859cf686-72d6-4eb7-bd34-c96c0ab0be66');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '1b63b752-2de3-47f7-acd8-c2ca3bc2a220');
insert into roles_authorities(role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '00b5ed19-ed3a-4997-94a7-8069ffa9ae58');

-- rank
insert into rank(id, discount, name, seeds) values ('6b8085ff-1ec4-4308-8112-37d33086f9e1', 0, 'BRONZE', 0);
insert into rank(id, discount, name, seeds) values ('fca0a4ab-3ec8-4c3a-a921-2d3705a273a9', 4, 'SILVER', 20);
insert into rank(id, discount, name, seeds) values ('10fae5e4-496a-4321-91ca-876858a3b36b', 7, 'GOLD', 60);
insert into rank(id, discount, name, seeds) values ('ba8c4613-46da-4684-8f8c-2ccfb3e4925d', 9, 'PLATINUM', 140);
insert into rank(id, discount, name, seeds) values ('0fdc8bcb-9ed6-4212-9133-2bc3d99d22e0', 10, 'DIAMOND', 300);

-- status
insert into status(id, name) values ('44a0f481-7d63-47f1-94f5-bd2486bee826', 'PAID');
insert into status(id, name) values ('f10a0fc1-0b6c-4f6e-8bb4-541cab0a0037', 'SHIPPED');
insert into status(id, name) values ('7b340dc9-e8ec-4c92-ad8d-993f92631b78', 'DELIVERED');

-- country
insert into country(id, code, name) values ('17047597-b7ae-486e-89e7-cd3fd76cf2df', 'CH', 'Schweiz');
insert into country(id, code, name) values ('afb531cd-01b9-4b6e-b2fb-893261192890', 'DE', 'Deutschland');
insert into country(id, code, name) values ('2a6eb2c4-e403-49f2-b860-cd3cb276fab3', 'IT', 'Italien');
insert into country(id, code, name) values ('34f4d08a-79c6-4706-b3c3-c4db177621e9', 'FR', 'Frankreich');

-- teatype
insert into teatype(id, name, min_age, rank_id) values ('9c442c4b-2011-4b96-be2c-8b9c4cc59928', 'White', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('58fd364c-7e77-4cde-b5ab-1de9a458cd47', 'White', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('be303e74-c2c4-487f-bbe8-af9a719fb603', 'Green', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('4e1c123b-8570-49c2-883a-7ede1145bb07', 'Green', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('893f9861-19e0-4849-ba61-46a6b92fbae5', 'Matcha', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('28172802-59a2-4745-aa08-5317663403dd', 'Matcha', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('61cffce7-02ef-4172-b1af-d175c88da320', 'Yellow', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('fe0c65a2-6be9-4ca1-a114-fb8059d2c380', 'Yellow', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('9d62120b-5233-46b7-abe3-d5fe2548e180', 'Oolong', 0, 'ba8c4613-46da-4684-8f8c-2ccfb3e4925d');
insert into teatype(id, name, min_age, rank_id) values ('930024a4-db58-40d4-86e8-118a357ca921', 'Oolong', 0, 'ba8c4613-46da-4684-8f8c-2ccfb3e4925d');
insert into teatype(id, name, min_age, rank_id) values ('78095b66-4d0b-4d47-a2b0-15de69999178', 'Black', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('89869768-b379-4c09-8f88-9ed20bf14dbf', 'Black', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('30a4e53e-8a6a-4610-a1ad-c1b06f6c6ebf', 'Raw Puerh', 0, 'ba8c4613-46da-4684-8f8c-2ccfb3e4925d');
insert into teatype(id, name, min_age, rank_id) values ('2f895ffa-a07d-418e-8b3e-965fea178904', 'Raw Puerh', 0, 'ba8c4613-46da-4684-8f8c-2ccfb3e4925d');
insert into teatype(id, name, min_age, rank_id) values ('b06b42c9-9193-4b54-9a21-6dee51dd4c40', 'Ripened', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('41c28c5f-b5af-4bfd-ae9c-4b49c0e9cc47', 'Ripened', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('53823cf1-889b-4467-b895-ee975f9b21d9', 'Tisanes', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('cbf7274d-60ed-479c-889c-3d54491276dc', 'Tisanes', 0, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('e5b5512b-5220-4793-94fe-55261cafd59e', 'Medicinal Herbs', 18, '6b8085ff-1ec4-4308-8112-37d33086f9e1');
insert into teatype(id, name, min_age, rank_id) values ('df21ac3b-38fd-4d97-8686-42b5a9c01c28', 'Medicinal Herbs', 18, '6b8085ff-1ec4-4308-8112-37d33086f9e1');

-- tea
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ( 'd88f4d92-d225-43e0-8e56-386167609c7b', 'Silver Needle', '2022-08-08', 5.95, 7.95, 25, '2a6eb2c4-e403-49f2-b860-cd3cb276fab3', '9c442c4b-2011-4b96-be2c-8b9c4cc59928');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('a914b03e-cc9f-4dc9-b886-ac2a0503b21e', 'Purple Bud', '2022-08-05', 4.65, 6.65, 94, '2a6eb2c4-e403-49f2-b860-cd3cb276fab3', '58fd364c-7e77-4cde-b5ab-1de9a458cd47');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('2b63f983-e139-428f-a175-3395344d4457', 'Jade Fire', '2022-08-07', 8.05, 10.05, 97, '17047597-b7ae-486e-89e7-cd3fd76cf2df', 'be303e74-c2c4-487f-bbe8-af9a719fb603');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('d3dba7f4-ce4e-4df8-a3f6-4d6512349a8a', 'Fur Peak', '2022-08-09', 7.45, 9.45, 27, '17047597-b7ae-486e-89e7-cd3fd76cf2df', '4e1c123b-8570-49c2-883a-7ede1145bb07');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('c8a45db9-476e-45a3-a601-28cf52d76e11', 'Genmai', '2022-08-08', 3.95, 5.95, 93, '34f4d08a-79c6-4706-b3c3-c4db177621e9', '893f9861-19e0-4849-ba61-46a6b92fbae5');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('0e1059f7-2265-497f-b8d9-b5ab2f7cbb11', 'Master''s', '2022-08-02', 4.65, 6.65, 38, '34f4d08a-79c6-4706-b3c3-c4db177621e9', '28172802-59a2-4745-aa08-5317663403dd');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('c102913e-291e-4cca-8e3a-edcc30b179a6', 'Amber Mountain', '2022-08-09', 11.75, 13.75, 76, '2a6eb2c4-e403-49f2-b860-cd3cb276fab3', '61cffce7-02ef-4172-b1af-d175c88da320');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('2a1c5542-bbda-4d5f-b574-bba016a2b679', 'Diamond Peak', '2022-08-06', 6.95, 8.95, 34, '2a6eb2c4-e403-49f2-b860-cd3cb276fab3', 'fe0c65a2-6be9-4ca1-a114-fb8059d2c380');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('f684e479-162b-4d97-9ffd-a7c33b0c6920', 'Duck Sh*t', '2022-08-12', 5.50, 7.50, 38, '2a6eb2c4-e403-49f2-b860-cd3cb276fab3', '9d62120b-5233-46b7-abe3-d5fe2548e180');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('45dbecdc-1517-42bf-89ac-5e761690151b', 'Summer Haze', '2022-08-16', 2.30, 4.30, 55, '2a6eb2c4-e403-49f2-b860-cd3cb276fab3', '930024a4-db58-40d4-86e8-118a357ca921');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('c2c33636-2bbb-41ba-9ce9-6eb214b3ce5c', 'Cocoa Malt Queen', '2022-08-15', 5.45, 7.45 , 85, '2a6eb2c4-e403-49f2-b860-cd3cb276fab3', '78095b66-4d0b-4d47-a2b0-15de69999178');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('68d917bc-f8ca-4e1b-943b-98dcf9bb5981', 'Souchong Liquor', '2022-08-07', 4.80, 6.80, 68, '2a6eb2c4-e403-49f2-b860-cd3cb276fab3', '89869768-b379-4c09-8f88-9ed20bf14dbf');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('0b5bec7e-267e-4fcc-afd3-a39071ab3f8c', 'Purple Bud', '2022-08-11', 8.60, 10.60, 93, '34f4d08a-79c6-4706-b3c3-c4db177621e9', '30a4e53e-8a6a-4610-a1ad-c1b06f6c6ebf');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('92166fd7-e7fe-4f3f-9db1-63ef60296bcb', 'Young Gushu', '2022-08-04', 7.50, 9.50, 35, '34f4d08a-79c6-4706-b3c3-c4db177621e9', '2f895ffa-a07d-418e-8b3e-965fea178904');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('7367d3cd-1c39-484f-b13c-cbe838e321f8', 'Nug Berry', '2022-08-09', 3.45, 5.45, 19, 'afb531cd-01b9-4b6e-b2fb-893261192890', 'b06b42c9-9193-4b54-9a21-6dee51dd4c40');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('8de60ae3-d261-4c02-9df1-0b9b059c25e2', 'Bling Rock Kingpin', '2022-08-13', 4.60, 6.60, 87, 'afb531cd-01b9-4b6e-b2fb-893261192890', '41c28c5f-b5af-4bfd-ae9c-4b49c0e9cc47');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('d069e729-7fd7-4bf5-ab9d-d6442a8e89d9', 'Chrysanthemum Flowers', '2022-08-15', 11.95, 13.9, 34, 'afb531cd-01b9-4b6e-b2fb-893261192890', '53823cf1-889b-4467-b895-ee975f9b21d9');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('3a91cc73-4432-4794-84e2-8c6f701148b5', 'Ginkgo Leaf', '2022-08-05', 6.89, 8.89, 76, 'afb531cd-01b9-4b6e-b2fb-893261192890', 'cbf7274d-60ed-479c-889c-3d54491276dc');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ( '7a52fa15-d95a-4782-b61c-f4043749e282', 'Angelica Root', '2022-08-02', 5.55, 7.55, 64, '17047597-b7ae-486e-89e7-cd3fd76cf2df', 'e5b5512b-5220-4793-94fe-55261cafd59e');
insert into tea(id, name, harvest_date, purchase_price, selling_price, stock_number, country_id, teatype_id) values ('5572520c-deab-4d6a-8628-8944a32d9d58', 'Senna Leaves', '2022-08-16', 2.79, 4.79, 23, '17047597-b7ae-486e-89e7-cd3fd76cf2df', 'df21ac3b-38fd-4d97-8686-42b5a9c01c28');