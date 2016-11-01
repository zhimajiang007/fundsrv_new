package com.homaer.fundsrv.web.listener;

import java.util.HashMap;
import java.util.Map;

import com.homaer.common.tools.urlrewriter.permalink.GenericPermalinkDefinition;
import com.homaer.common.tools.urlrewriter.servlet.listener.URLRewriteListener;

public class URLListener extends URLRewriteListener {

    @SuppressWarnings("unused")
    private static final String CMS      = "/cms/";
    @SuppressWarnings("unused")
    private static final String PAST     = "/past";
    @SuppressWarnings("unused")
    private static final String INDEX    = "/index/";
    @SuppressWarnings("unused")
    private static final String QUESTION = "/question";
    @SuppressWarnings("unused")
    private static final String TRANSFER = "/transfer";
    @SuppressWarnings("unused")
    private static final String INFO     = "/info/";
    @SuppressWarnings("unused")
    private static final String SLASH    = "/";

    @Override
    public Map<String, String> initRules() {
        Map<String, String> rules = new HashMap<String, String>();
        initBasic(rules);
        initIntroductions(rules);
        return rules;
    }

    private void initBasic(Map<String, String> rules) {
        rules.put("/", "/index");
        rules.put("/index.jsp", "/index");
        rules.put("/index.html", "/index");
        rules.put("/past", "/index/past");
        rules.put("/help", "/index/help");
        rules.put("/question", "/info/question");
        rules.put("/transfer", "/info/transfer");
        rules.put("/(\\d+)", "/index/$1");
    }

    private void initIntroductions(Map<String, String> rules) {
//        ContentService contentService = getBean("contentService");
//        List<Content> introductions = contentService.listIntroductions();
//        for (Content introduction : introductions) {
//            if (introduction != null) {
//                String nick = introduction.getNick();
//                rules.put(SLASH + nick, CMS + nick);
//            }
//        }
    }

    @Override
    public Map<GenericPermalinkDefinition, String> initPDs() {
        Map<GenericPermalinkDefinition, String> pds = new HashMap<GenericPermalinkDefinition, String>();
        return pds;
    }

}
