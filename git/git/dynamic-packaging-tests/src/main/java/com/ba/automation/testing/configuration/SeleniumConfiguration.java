package com.ba.automation.testing.configuration;

import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

import static java.lang.String.format;

/**
 * Created by n450777 on 04/04/2016.
 */
@ScenarioScoped
public class SeleniumConfiguration {

    @Inject
    private BuildNameProvider buildNameProvider;

    private final static Logger log = Logger
            .getLogger(SeleniumConfiguration.class.getName());

    private Properties props = new Properties();

    public SeleniumConfiguration() {
        readFromuserProperties();
        readFromEnvironment();
        readFromSystemProperies();
    }

    private void readFromuserProperties() {
        File testPropertiesFile = new File("test.properties");
        if (testPropertiesFile.exists()) {
            try {
                props.load(new InputStreamReader(
                        new FileInputStream(testPropertiesFile)));
            } catch (IOException e) {
                log.severe(e.getMessage());
            }
        }
    }

    private void readFromSystemProperies() {
        System
                .getProperties().entrySet().stream()
                .filter(sysProp -> sysProp.getKey().toString()
                        .startsWith("selenium.") ||
                        sysProp.getKey().toString().startsWith("sauce."))
                .forEach(sysProp -> {
                    props.put(sysProp.getKey(), sysProp.getValue());
                });
    }

    private void readFromEnvironment() {
        System.getenv()
                .entrySet().stream()
                .filter(envVar -> envVar.getKey().startsWith("SELENIUM_") ||
                        envVar.getKey().startsWith("SAUCE_"))
                .forEach(envVar -> {
                    props.put(
                            envVar.getKey().replace("_", ".")
                                    .toLowerCase(),
                            envVar.getValue()
                    );
                });
    }

    public URL getSeleniumUrl() {
        try {
            return new URL(
                    format("http://%s/wd/hub", getSeleniumProperty("host")));
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private String getSeleniumProperty(String property,
            String... defaultValue) {
        return getSeleniumProperty("selenium", property, null);
    }

    private String getSauceProperty(String property, String... defaultValue) {
        return getSeleniumProperty("sauce", property, null);
    }

    private String getSeleniumProperty(String prefix, String property,
            String defaultValue) {
        return props
                .getProperty(format("%s.%s", prefix, property), defaultValue);
    }

    private Properties getSeleniumProperties() {
        Properties selProps = new Properties();
        props.entrySet().stream().filter(prop -> prop.getKey().toString()
                .startsWith("selenium."))
                .forEach(prop -> selProps.put(prop.getKey().toString().replace("selenium.", ""), prop.getValue()));
        return selProps;
    }

    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();

        getSeleniumProperties().entrySet().stream()
                .forEach(prop -> {
                    caps.setCapability(
                            prop.getKey().toString(),
                            prop.getValue().toString());
                });

        if(getSauceProperty("user.name") != null) {
            caps.setCapability("username", getSauceProperty("user.name"));
            caps.setCapability("access-key", getSauceProperty("api.key"));
        }

        String browser = getSeleniumProperty("browser");
        if(browser != null) {
            caps.setBrowserName(browser);
        }

        String device = getSeleniumProperty("device");
        if(device != null) {
            caps.setCapability("deviceName", device);
        }

        String buildName = buildNameProvider.getBuildName();
        if(buildName != null) {
            caps.setCapability("build", buildName);
        }

        return caps;
    }

}
