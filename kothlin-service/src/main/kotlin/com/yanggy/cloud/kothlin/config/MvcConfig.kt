package com.yanggy.cloud.kothlin.config;

import com.alibaba.fastjson.serializer.SerializerFeature
import com.alibaba.fastjson.support.config.FastJsonConfig
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

/**
 *@author derrick.yang
 *@Date 24/10/2018 16:49
 */

@Configuration
class MvcConfig : WebMvcConfigurationSupport() {
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        super.configureMessageConverters(converters)
        var fastConverter: FastJsonHttpMessageConverter = FastJsonHttpMessageConverter()

        var fastJsonConfig: FastJsonConfig = FastJsonConfig()
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat)

        var fastMediaType: MutableList<MediaType> = mutableListOf()
        fastMediaType.add(MediaType.APPLICATION_JSON_UTF8)

        fastConverter.fastJsonConfig = fastJsonConfig
        fastConverter.supportedMediaTypes = fastMediaType

        converters.add(fastConverter)
    }
}