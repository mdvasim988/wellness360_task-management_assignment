INSERT INTO task(title, description, due_date, task_status, created_at, updated_at)
VALUES ('Review Backend Assignment', 'Check the package structure and code quality.', DATEADD('DAY', 2, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Review Backend Assignment', 'Check the package structure and code quality.', DATEADD('DAY', 2, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Review Backend Assignment', 'Check the package structure and code quality.', DATEADD('DAY', 2, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Setup Database Schema', 'Initialize H2 configuration and write baseline scripts.', DATEADD('DAY', -1, CURRENT_DATE()), 'COMPLETED', NOW(), NOW()),
       ('Implement MapStruct Mappers', 'Replace old ModelMapper configurations with compile-time mappers.', DATEADD('DAY', 1, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Write Unit Tests', 'Achieve 80% code coverage on task service business logic.', DATEADD('DAY', 4, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Fix Lombok Compiler Error', 'Upgrade Lombok version to solve the TypeTag UNKNOWN crash.', DATEADD('DAY', 0, CURRENT_DATE()), 'COMPLETED', NOW(), NOW()),
       ('Configure Spring Security', 'Block or allow endpoint access for the H2 console path.', DATEADD('DAY', 5, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Validate PUT Request Formats', 'Ensure incoming JSON payload dates match ISO 8601 criteria.', DATEADD('DAY', 3, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Refactor Record DTOs', 'Clean up immutable component fields and test serialization.', DATEADD('DAY', 2, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Optimize Hibernate Queries', 'Analyze console log outputs and trace N+1 fetch problems.', DATEADD('DAY', 7, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW()),
       ('Deploy to Staging Environment', 'Run final smoke tests on target platform environment.', DATEADD('DAY', 10, CURRENT_DATE()), 'IN_PROGRESS', NOW(), NOW());