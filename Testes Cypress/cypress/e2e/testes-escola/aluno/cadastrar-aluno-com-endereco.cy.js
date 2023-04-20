describe("Cadastrar aluno com Endereço", () => {
    it("Cadastrar aluno com endereço", () => {

        const aluno = {
            nome: "Felipe",
            email: "felipe@gmail",
            telefone: "88845959",
            endereco: { rua: "Amazonas", numero: 240, cidade: "Jaraguá do Sul", estado: "SC", bairro: "Centro", cep: 89253030 }
        }

        cy.request("POST", "http://localhost:8085/aluno", aluno).as("CadastrarAluno");
        cy.get("@CadastrarAluno").then(response => {
            expect(response.body).to.have.property("endereco");
        })
    })
})