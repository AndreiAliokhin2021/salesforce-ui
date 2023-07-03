package config;

import org.aeonbits.owner.Config;

public interface UserConfig extends Config {

    @Key("username")
    @DefaultValue("sdypbo-q6qy@force.com")
    String username();

    @Key("password")
    @DefaultValue("Yebd!5LnC!Bt8TF")
    String password();
}
