describe("Buscar aluno com seu Endereço", () => {
    it("Buscar Aluno pelo seu ID junto com seu Endereço", () => {
        cy.request("GET", "http://localhost:8085/aluno/1").as("BuscarAlunoComEndereco");
        cy.get("@BuscarAlunoComEndereco").then(response => {
            expect(response.body).to.have.property("id").to.eq(1);
            expect(response.body).to.have.property("endereco");
        })
    })
})