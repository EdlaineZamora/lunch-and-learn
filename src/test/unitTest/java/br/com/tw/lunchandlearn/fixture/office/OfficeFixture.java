package br.com.tw.lunchandlearn.fixture.office;

import br.com.tw.lunchandlearn.domain.office.Office;

public class OfficeFixture {

    private String name;

    private OfficeFixture() {
        this.name = "Belo Horizonte";
    }

    public static OfficeFixture anOffice() {
        return new OfficeFixture();
    }

    public OfficeFixture withName(String name) {
        this.name = name;
        return this;
    }

    public Office build() {
        return new Office(name);
    }

}
