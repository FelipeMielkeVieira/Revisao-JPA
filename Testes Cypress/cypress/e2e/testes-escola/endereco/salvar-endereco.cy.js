describe("Salvar Endereço com sucesso", () => {
    it("Salvar Endereço funciona", () => {
        cy.request("POST", "http://localhost:8085/endereco", {rua: "Amazonas", numero: 240, cidade: "Jaraguá do Sul", estado: "SC", bairro: "Centro", cep: 89253030}).as("CadastrarEndereco");
        cy.get("@CadastrarEndereco").then(response => {
            expect(response.body).to.have.property('id')
        })
    })
})