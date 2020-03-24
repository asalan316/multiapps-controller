package com.sap.cloud.lm.sl.cf.process.variables;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cloudfoundry.client.lib.StartingInfo;
import org.cloudfoundry.client.lib.domain.CloudApplication;
import org.cloudfoundry.client.lib.domain.CloudServiceBroker;
import org.cloudfoundry.client.lib.domain.CloudServiceKey;
import org.cloudfoundry.client.lib.domain.CloudTask;
import org.cloudfoundry.client.lib.domain.UploadToken;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sap.cloud.lm.sl.cf.client.lib.domain.CloudApplicationExtended;
import com.sap.cloud.lm.sl.cf.client.lib.domain.CloudServiceExtended;
import com.sap.cloud.lm.sl.cf.core.helpers.MtaArchiveElements;
import com.sap.cloud.lm.sl.cf.core.model.ConfigurationEntry;
import com.sap.cloud.lm.sl.cf.core.model.ConfigurationSubscription;
import com.sap.cloud.lm.sl.cf.core.model.DeployedMta;
import com.sap.cloud.lm.sl.cf.core.model.ServiceOperation;
import com.sap.cloud.lm.sl.cf.process.Constants;
import com.sap.cloud.lm.sl.mta.model.DeploymentDescriptor;
import com.sap.cloud.lm.sl.mta.model.Hook;
import com.sap.cloud.lm.sl.mta.model.Module;

public interface Variables {

    Variable<String> CORRELATION_ID = ImmutableVariable.<String> builder()
                                                       .name(Constants.VAR_CORRELATION_ID)
                                                       .build();
    Variable<String> ORG = ImmutableVariable.<String> builder()
                                            .name(Constants.VAR_ORG)
                                            .build();
    Variable<String> SPACE = ImmutableVariable.<String> builder()
                                              .name(Constants.VAR_SPACE)
                                              .build();
    Variable<String> ORG_ID = ImmutableVariable.<String> builder()
                                               .name(Constants.VAR_ORG_ID)
                                               .build();
    Variable<String> SPACE_ID = ImmutableVariable.<String> builder()
                                                 .name(com.sap.cloud.lm.sl.cf.persistence.Constants.VARIABLE_NAME_SPACE_ID)
                                                 .build();
    Variable<String> NEW_MTA_VERSION = ImmutableVariable.<String> builder()
                                                        .name(Constants.VAR_NEW_MTA_VERSION)
                                                        .build();
    Variable<String> PARENT_PROCESS_ID = ImmutableVariable.<String> builder()
                                                          .name(Constants.VAR_PARENT_PROCESS_ID)
                                                          .build();
    Variable<String> SUBPROCESS_ID = ImmutableVariable.<String> builder()
                                                      .name(Constants.VAR_SUBPROCESS_ID)
                                                      .build();
    Variable<String> SERVICE_ID = ImmutableVariable.<String> builder()
                                                   .name(com.sap.cloud.lm.sl.cf.persistence.Constants.VARIABLE_NAME_SERVICE_ID)
                                                   .build();
    Variable<String> TASK_ID = ImmutableVariable.<String> builder()
                                                .name(Constants.TASK_ID)
                                                .build();
    Variable<String> SERVICE_TO_PROCESS_NAME = ImmutableVariable.<String> builder()
                                                                .name(Constants.VAR_SERVICE_TO_PROCESS_NAME)
                                                                .build();
    Variable<Integer> MTA_MAJOR_SCHEMA_VERSION = ImmutableVariable.<Integer> builder()
                                                                  .name(Constants.VAR_MTA_MAJOR_SCHEMA_VERSION)
                                                                  .build();
    Variable<Integer> START_TIMEOUT = ImmutableVariable.<Integer> builder()
                                                       .name(Constants.PARAM_START_TIMEOUT)
                                                       .defaultValue(Constants.DEFAULT_START_TIMEOUT)
                                                       .build();
    Variable<Boolean> SKIP_MANAGE_SERVICE_BROKER = ImmutableVariable.<Boolean> builder()
                                                                    .name(Constants.VAR_SKIP_MANAGE_SERVICE_BROKER)
                                                                    .build();
    Variable<Boolean> VERIFY_ARCHIVE_SIGNATURE = ImmutableVariable.<Boolean> builder()
                                                                  .name(Constants.PARAM_VERIFY_ARCHIVE_SIGNATURE)
                                                                  .build();
    Variable<Boolean> DELETE_IDLE_URIS = ImmutableVariable.<Boolean> builder()
                                                          .name(Constants.VAR_DELETE_IDLE_URIS)
                                                          .defaultValue(false)
                                                          .build();
    Variable<Boolean> USE_IDLE_URIS = ImmutableVariable.<Boolean> builder()
                                                       .name(Constants.VAR_USE_IDLE_URIS)
                                                       .defaultValue(false)
                                                       .build();
    Variable<Boolean> USE_NAMESPACES = ImmutableVariable.<Boolean> builder()
                                                        .name(Constants.PARAM_USE_NAMESPACES)
                                                        .defaultValue(false)
                                                        .build();
    Variable<Boolean> USE_NAMESPACES_FOR_SERVICES = ImmutableVariable.<Boolean> builder()
                                                                     .name(Constants.PARAM_USE_NAMESPACES_FOR_SERVICES)
                                                                     .defaultValue(false)
                                                                     .build();
    Variable<Boolean> IS_SERVICE_UPDATED = ImmutableVariable.<Boolean> builder()
                                                            .name(Constants.VAR_IS_SERVICE_UPDATED)
                                                            .defaultValue(false)
                                                            .build();
    Variable<Boolean> SKIP_UPDATE_CONFIGURATION_ENTRIES = ImmutableVariable.<Boolean> builder()
                                                                           .name(Constants.VAR_SKIP_UPDATE_CONFIGURATION_ENTRIES)
                                                                           .defaultValue(false)
                                                                           .build();
    Variable<Boolean> FAIL_ON_CRASHED = ImmutableVariable.<Boolean> builder()
                                                         .name(Constants.PARAM_FAIL_ON_CRASHED)
                                                         .defaultValue(true)
                                                         .build();
    Variable<Boolean> USER_PROPERTIES_CHANGED = ImmutableVariable.<Boolean> builder()
                                                                 .name(Constants.VAR_USER_PROPERTIES_CHANGED)
                                                                 .defaultValue(false)
                                                                 .build();
    Variable<Boolean> VCAP_APP_PROPERTIES_CHANGED = ImmutableVariable.<Boolean> builder()
                                                                     .name(Constants.VAR_VCAP_APP_PROPERTIES_CHANGED)
                                                                     .defaultValue(false)
                                                                     .build();
    Variable<Boolean> VCAP_SERVICES_PROPERTIES_CHANGED = ImmutableVariable.<Boolean> builder()
                                                                          .name(Constants.VAR_VCAP_SERVICES_PROPERTIES_CHANGED)
                                                                          .defaultValue(false)
                                                                          .build();
    Variable<Boolean> SHOULD_SKIP_SERVICE_REBINDING = ImmutableVariable.<Boolean> builder()
                                                                       .name(Constants.VAR_SHOULD_SKIP_SERVICE_REBINDING)
                                                                       .defaultValue(false)
                                                                       .build();
    Variable<Boolean> DELETE_SERVICES = ImmutableVariable.<Boolean> builder()
                                                         .name(Constants.PARAM_DELETE_SERVICES)
                                                         .defaultValue(false)
                                                         .build();
    Variable<Boolean> DELETE_SERVICE_KEYS = ImmutableVariable.<Boolean> builder()
                                                             .name(Constants.PARAM_DELETE_SERVICE_KEYS)
                                                             .defaultValue(false)
                                                             .build();
    Variable<DeploymentDescriptor> DEPLOYMENT_DESCRIPTOR = ImmutableVariable.<DeploymentDescriptor> builder()
                                                                            .name(Constants.VAR_MTA_DEPLOYMENT_DESCRIPTOR)
                                                                            .type(Variable.typeReference(DeploymentDescriptor.class))
                                                                            .serializationStrategy(SerializationStrategy.JSON_STRING)
                                                                            .build();
    Variable<DeploymentDescriptor> DEPLOYMENT_DESCRIPTOR_WITH_SYSTEM_PARAMETERS = ImmutableVariable.<DeploymentDescriptor> builder()
                                                                                                   .name(Constants.VAR_MTA_DEPLOYMENT_DESCRIPTOR_WITH_SYSTEM_PARAMETERS)
                                                                                                   .type(Variable.typeReference(DeploymentDescriptor.class))
                                                                                                   .serializationStrategy(SerializationStrategy.JSON_STRING)
                                                                                                   .build();
    Variable<DeploymentDescriptor> COMPLETE_DEPLOYMENT_DESCRIPTOR = ImmutableVariable.<DeploymentDescriptor> builder()
                                                                                     .name(Constants.VAR_COMPLETE_MTA_DEPLOYMENT_DESCRIPTOR)
                                                                                     .type(Variable.typeReference(DeploymentDescriptor.class))
                                                                                     .serializationStrategy(SerializationStrategy.JSON_STRING)
                                                                                     .build();
    Variable<CloudApplicationExtended> APP_TO_PROCESS = ImmutableVariable.<CloudApplicationExtended> builder()
                                                                         .name(Constants.VAR_APP_TO_PROCESS)
                                                                         .type(Variable.typeReference(CloudApplicationExtended.class))
                                                                         .serializationStrategy(SerializationStrategy.JSON_STRING)
                                                                         .build();
    Variable<MtaArchiveElements> MTA_ARCHIVE_ELEMENTS = ImmutableVariable.<MtaArchiveElements> builder()
                                                                         .name(Constants.VAR_MTA_ARCHIVE_ELEMENTS)
                                                                         .type(Variable.typeReference(MtaArchiveElements.class))
                                                                         .defaultValue(new MtaArchiveElements())
                                                                         .serializationStrategy(SerializationStrategy.JSON_STRING)
                                                                         .build();
    Variable<CloudServiceExtended> SERVICE_TO_PROCESS = ImmutableVariable.<CloudServiceExtended> builder()
                                                                         .name(Constants.VAR_SERVICE_TO_PROCESS)
                                                                         .type(Variable.typeReference(CloudServiceExtended.class))
                                                                         .serializationStrategy(SerializationStrategy.JSON_STRING)
                                                                         .build();
    Variable<UploadToken> UPLOAD_TOKEN = ImmutableVariable.<UploadToken> builder()
                                                          .name(Constants.VAR_UPLOAD_TOKEN)
                                                          .type(Variable.typeReference(UploadToken.class))
                                                          .serializationStrategy(SerializationStrategy.JSON_STRING)
                                                          .build();
    Variable<Hook> HOOK_FOR_EXECUTION = ImmutableVariable.<Hook> builder()
                                                         .name(Constants.VAR_HOOK_FOR_EXECUTION)
                                                         .type(Variable.typeReference(Hook.class))
                                                         .serializationStrategy(SerializationStrategy.JSON_STRING)
                                                         .build();
    Variable<List<String>> APPS_TO_DEPLOY = ImmutableVariable.<List<String>> builder()
                                                             .name(Constants.VAR_APPS_TO_DEPLOY)
                                                             .type(new TypeReference<List<String>>() {
                                                             })
                                                             .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                             .build();
    Variable<List<String>> APPS_TO_RENAME = ImmutableVariable.<List<String>> builder()
                                                             .name(Constants.VAR_APPS_TO_RENAME)
                                                             .type(new TypeReference<List<String>>() {
                                                             })
                                                             .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                             .build();
    Variable<List<ConfigurationEntry>> CONFIGURATION_ENTRIES_TO_PUBLISH = ImmutableVariable.<List<ConfigurationEntry>> builder()
                                                                                           .name(Constants.VAR_CONFIGURATION_ENTRIES_TO_PUBLISH)
                                                                                           .type(new TypeReference<List<ConfigurationEntry>>() {
                                                                                           })
                                                                                           .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                                           .build();
    Variable<List<ConfigurationEntry>> DELETED_ENTRIES = ImmutableVariable.<List<ConfigurationEntry>> builder()
                                                                          .name(Constants.VAR_DELETED_ENTRIES)
                                                                          .type(new TypeReference<List<ConfigurationEntry>>() {
                                                                          })
                                                                          .defaultValue(Collections.emptyList())
                                                                          .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                          .build();
    Variable<List<ConfigurationEntry>> PUBLISHED_ENTRIES = ImmutableVariable.<List<ConfigurationEntry>> builder()
                                                                            .name(Constants.VAR_PUBLISHED_ENTRIES)
                                                                            .type(new TypeReference<List<ConfigurationEntry>>() {
                                                                            })
                                                                            .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                            .build();
    Variable<CloudServiceBroker> CREATED_OR_UPDATED_SERVICE_BROKER = ImmutableVariable.<CloudServiceBroker> builder()
                                                                                      .name(Constants.VAR_CREATED_OR_UPDATED_SERVICE_BROKER)
                                                                                      .type(Variable.typeReference(CloudServiceBroker.class))
                                                                                      .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                                      .build();
    Variable<List<String>> CUSTOM_DOMAINS = ImmutableVariable.<List<String>> builder()
                                                             .name(Constants.VAR_CUSTOM_DOMAINS)
                                                             .type(new TypeReference<List<String>>() {
                                                             })
                                                             .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                             .build();
    Variable<DeployedMta> DEPLOYED_MTA = ImmutableVariable.<DeployedMta> builder()
                                                          .name(Constants.VAR_DEPLOYED_MTA)
                                                          .type(Variable.typeReference(DeployedMta.class))
                                                          .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                          .build();
    Variable<CloudApplication> EXISTING_APP = ImmutableVariable.<CloudApplication> builder()
                                                               .name(Constants.VAR_EXISTING_APP)
                                                               .type(Variable.typeReference(CloudApplication.class))
                                                               .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                               .build();
    Variable<Module> MODULE_TO_DEPLOY = ImmutableVariable.<Module> builder()
                                                         .name(Constants.VAR_MODULE_TO_DEPLOY)
                                                         .type(Variable.typeReference(Module.class))
                                                         .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                         .build();
    Variable<Set<String>> MTA_ARCHIVE_MODULES = ImmutableVariable.<Set<String>> builder()
                                                                 .name(Constants.VAR_MTA_ARCHIVE_MODULES)
                                                                 .type(new TypeReference<Set<String>>() {
                                                                 })
                                                                 .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                 .build();
    Variable<Set<String>> MTA_MODULES = ImmutableVariable.<Set<String>> builder()
                                                         .name(Constants.VAR_MTA_MODULES)
                                                         .type(new TypeReference<Set<String>>() {
                                                         })
                                                         .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                         .build();
    Variable<Map<String, Map<String, String>>> SERVICE_KEYS_CREDENTIALS_TO_INJECT = ImmutableVariable.<Map<String, Map<String, String>>> builder()
                                                                                                     .name(Constants.VAR_SERVICE_KEYS_CREDENTIALS_TO_INJECT)
                                                                                                     .type(new TypeReference<Map<String, Map<String, String>>>() {
                                                                                                     })
                                                                                                     .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                                                     .build();
    Variable<Map<String, List<CloudServiceKey>>> SERVICE_KEYS_TO_CREATE = ImmutableVariable.<Map<String, List<CloudServiceKey>>> builder()
                                                                                           .name(Constants.VAR_SERVICE_KEYS_TO_CREATE)
                                                                                           .type(new TypeReference<Map<String, List<CloudServiceKey>>>() {
                                                                                           })
                                                                                           .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                                           .build();
    Variable<String> SERVICE_TO_DELETE = ImmutableVariable.<String> builder()
                                                          .name(Constants.VAR_SERVICE_TO_DELETE)
                                                          .serializationStrategy(SerializationStrategy.DIRECT)
                                                          .build();
    Variable<List<String>> SERVICES_TO_DELETE = ImmutableVariable.<List<String>> builder()
                                                                 .name(Constants.VAR_SERVICES_TO_DELETE)
                                                                 .serializationStrategy(SerializationStrategy.DIRECT)
                                                                 .build();
    Variable<List<CloudServiceExtended>> SERVICES_TO_POLL = ImmutableVariable.<List<CloudServiceExtended>> builder()
                                                                             .name(Constants.VAR_SERVICES_TO_POLL)
                                                                             .type(new TypeReference<List<CloudServiceExtended>>() {
                                                                             })
                                                                             .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                             .build();
    Variable<CloudTask> STARTED_TASK = ImmutableVariable.<CloudTask> builder()
                                                        .name(Constants.VAR_STARTED_TASK)
                                                        .type(Variable.typeReference(CloudTask.class))
                                                        .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                        .build();
    Variable<StartingInfo> STARTING_INFO = ImmutableVariable.<StartingInfo> builder()
                                                            .name(Constants.VAR_STARTING_INFO)
                                                            .type(Variable.typeReference(StartingInfo.class))
                                                            .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                            .build();
    Variable<List<ConfigurationSubscription>> SUBSCRIPTIONS_TO_CREATE = ImmutableVariable.<List<ConfigurationSubscription>> builder()
                                                                                         .name(Constants.VAR_SUBSCRIPTIONS_TO_CREATE)
                                                                                         .type(new TypeReference<List<ConfigurationSubscription>>() {
                                                                                         })
                                                                                         .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                                         .build();
    Variable<List<ConfigurationSubscription>> SUBSCRIPTIONS_TO_DELETE = ImmutableVariable.<List<ConfigurationSubscription>> builder()
                                                                                         .name(Constants.VAR_SUBSCRIPTIONS_TO_DELETE)
                                                                                         .type(new TypeReference<List<ConfigurationSubscription>>() {
                                                                                         })
                                                                                         .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                                         .build();
    Variable<List<CloudTask>> TASKS_TO_EXECUTE = ImmutableVariable.<List<CloudTask>> builder()
                                                                  .name(Constants.VAR_TASKS_TO_EXECUTE)
                                                                  .type(new TypeReference<List<CloudTask>>() {
                                                                  })
                                                                  .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                  .build();
    Variable<Map<String, ServiceOperation.Type>> TRIGGERED_SERVICE_OPERATIONS = ImmutableVariable.<Map<String, ServiceOperation.Type>> builder()
                                                                                                 .name(Constants.VAR_TRIGGERED_SERVICE_OPERATIONS)
                                                                                                 .type(new TypeReference<Map<String, ServiceOperation.Type>>() {
                                                                                                 })
                                                                                                 .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                                                 .build();
    Variable<List<CloudApplication>> UPDATED_SERVICE_BROKER_SUBSCRIBERS = ImmutableVariable.<List<CloudApplication>> builder()
                                                                                           .name(Constants.VAR_UPDATED_SERVICE_BROKER_SUBSCRIBERS)
                                                                                           .type(new TypeReference<List<CloudApplication>>() {
                                                                                           })
                                                                                           .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                                           .build();
    Variable<List<CloudApplication>> UPDATED_SUBSCRIBERS = ImmutableVariable.<List<CloudApplication>> builder()
                                                                            .name(Constants.VAR_UPDATED_SUBSCRIBERS)
                                                                            .type(new TypeReference<List<CloudApplication>>() {
                                                                            })
                                                                            .serializationStrategy(SerializationStrategy.JSON_BINARY)
                                                                            .build();

}
